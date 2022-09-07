package utils;

import org.jsoup.Jsoup;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class GetEmailGmail {
    public List<String> readGmail() throws Exception {

        List<String> messageBody = new ArrayList<>();

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        session.getStore("imaps");

        Properties properties = new Properties();
        properties.put("mail.imap.host", "imap.mail.ru");
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        Session emailSession = Session.getDefaultInstance(properties);

        Store store = emailSession.getStore("imaps");

        store.connect("imap.mail.ru", "jane.doe2022@mail.ru", "VBgPaytE63ZyicGF48p3");

        Folder folderInbox = store.getFolder("INBOX");
        folderInbox.open(Folder.READ_ONLY);

        Message[] messages = folderInbox.getMessages();

        for (int i = messages.length - 1; i >= 0; i--) {
            Message message = messages[i];
            if (message.getSubject().contains("Verify your email for HiHome")) {
                messageBody.add(getTextFromMessage(messages[i]));
            }
        }
        folderInbox.close(false);
        store.close();
        return messageBody;
    }

    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result.append("\n").append(bodyPart.getContent());
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result.append("\n").append(Jsoup.parse(html).text());
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
            }
        }
        return result.toString();
    }

    public List<String> getVerificationLinks(List<String> messageBody) {
        ArrayList<String> links = new ArrayList<>();

        Pattern linkPattern = Pattern.compile(
                "^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$",
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        for (int i = 0; i < messageBody.size(); i++) {
            for (String element : messageBody.get(i).split("\r\n")) {
                if (linkPattern
                        .matcher(element)
                        .find()) {
                    links.add(element);
                }
            }
        }
        return links;
    }

    public void confirmRegistration() throws Exception {
        for (int i = 0; i < getVerificationLinks(readGmail()).size(); i++){
            getVerificationLinks(readGmail()).get(i);
        }
    }

    public static void main(String[] args) throws Exception {
        GetEmailGmail getEmail = new GetEmailGmail();
        getEmail.getVerificationLinks(getEmail.readGmail());
    }
}
