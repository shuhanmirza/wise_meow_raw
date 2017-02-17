/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wise_meow;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author shuhan
 */
public class LAUNCHER
{

    public static void main(String[] args)
    {
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.setStyle("robotic");
        voice.allocate();

        String res;
        String[] temp = new String[100];
        String str;

        int i, l, k;

        WiseMeow kevin = new WiseMeow();

        System.out.println("Hi , I am kevin...... I am a intellectual chatbot... ask me anything");
        voice.speak("Hi , I am kevin...... I am a intellectual chatbot... ask me anything.");

        Scanner s1 = new Scanner(System.in);

        while (true) {

            //test
            //test ends
            System.out.println("you: ");//get the query to search

            str = s1.nextLine();

            System.out.print("kevin: ");

            res = kevin.chat(str);

            System.out.println(res);
            voice.speak(res);

            l = res.length();

            //it is time to use jsoup
            //System.out.println(res.length());
        }

    }

    private void sendText( String res)
    {
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(res);
            dout.flush();
            dout.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(LAUNCHER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
