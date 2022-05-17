package utils;

import javax.mail.*;
import java.util.Properties;


public class GetEmailGmail {

    public void readGmail() throws Exception {

        CreatingTempMail createMailUtils = new CreatingTempMail();

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        session.getStore("imaps");

        Properties properties = new Properties();
        properties.put("mail.imap.host", "imap.gmail.com");
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        Session emailSession = Session.getDefaultInstance(properties);

        Store store = emailSession.getStore("imaps");

        store.connect("imap.gmail.com", "igyarashevich@gmail.com", "mypassword");

        Folder folderInbox = store.getFolder("INBOX");
        folderInbox.open(Folder.READ_ONLY);

        Message[] messages = folderInbox.getMessages();

        for (int i = messages.length - 1; i >= 0; i--) {
            Message message = messages[i];
            if (message.getSubject().contains("One click to confirm")) {
                System.out.println(message.getContent());
                break;
            }
        }

        folderInbox.close(false);
        store.close();
    }

    public static void main(String[] args) throws Exception {
        GetEmailGmail getEmail = new GetEmailGmail();
        getEmail.readGmail();
    }
}
