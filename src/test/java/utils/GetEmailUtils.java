package utils;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.Properties;


public class GetEmailUtils {

    public void readGmail() throws Exception {

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        session.getStore("imaps");
        Properties properties = new Properties();

        properties.put("mail.pop3.host", "pop.gmail.com");
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);

        Store store = emailSession.getStore("pop3s");

        store.connect("imap.gmail.com", "ina.yarashevich@gmail.com", "Orange@pepper%29");

        Folder folderInbox = store.getFolder("INBOX");
        folderInbox.open(Folder.READ_ONLY);
        /*Message message = null;
        for (int i = folderInbox.getMessageCount() - 1; i >= 0; i--){
            //if (folderInbox.getMessage(i).getSubject().contains("Critical security alert")){
            folderInbox.search()
                System.out.println(message.getReceivedDate());

        }*/
        SearchTerm searchCondition = new SearchTerm() {
            @Override
            public boolean match(Message message) {
                try {
                    if (message.getSubject().contains("One click to confirm")) {
                        return true;
                    }
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        };

        Message[] foundMessages = folderInbox.search(searchCondition);

        for (int i = foundMessages.length - 1; i >= 0; i++) {
            Message message = foundMessages[i];
            String subject = message.getSubject();
            System.out.println("Found message #" + i + ": " + subject);
        }
    }
    public static void main(String[] args) throws Exception {
        GetEmailUtils getEmail = new GetEmailUtils();

    }

}
