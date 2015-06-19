package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

// below line was like public class SmokeActivity extends ActionBarActivity {
public class SmokeActivity extends MainActivityHome {
    Button button;

    Button save, load;
    EditText message, message2, message3;
    String Message, Message2, Message3, MESSAGE_TOTAL, Message4, Message5, Message6;
    Spinner sp4, sp5, sp6;
    int data_block = 100;

    protected static String final_data;
    protected static String[] mySmokingTriggers = new String [250];
    private static int counter = 0;

    public static String final_dataSP4 = "";

    public static String addOhter5;
    public static String addOther6;
    public static String addOther4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke);

        final ImageView myPicture = (ImageView) findViewById(R.id.imageView2);
        final TextView myMessage = (TextView) findViewById(R.id.textView17);

        sp4 = (Spinner) findViewById(R.id.spinner4);
        sp5 = (Spinner) findViewById(R.id.spinner5);
        sp6 = (Spinner) findViewById(R.id.spinner6);

        save = (Button) findViewById(R.id.button4);
        load = (Button) findViewById(R.id.button3);   //LOAD IS THE SAME AS MY SMOKING TRIGGERS
        TextView saveSp4 = (TextView) findViewById(R.id.textView74);

        final TextView textView = (TextView) findViewById(R.id.textView23);

        //final TextView textView = (TextView) findViewById(R.id.textView24);
        /*for (int i = 0; i < 250; i++) {*/
/***********************************************************ADD another text only*/
        Message4 = "";
        try {
            //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
            FileInputStream fis = openFileInput("SP4.txt");
            //5. Get an object of the InputStreamReader class .
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            int size;
            //there is 80 character, this size will return into the variable size
            try {
                while ((size = isr.read(data)) > 0) {
                    //copy each string of data in this string read_data
                    String read_data = String.copyValueOf(data, 0, size);
                    //attach each piece of read_data the final string
                    final_dataSP4 = read_data;
                    data = new char[data_block];
                    Message4 = final_dataSP4;
                    Toast.makeText(getBaseContext(), "Data saved be13" + Message4, Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getBaseContext(), "Data saved be12" + Message4, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Toast.makeText(getBaseContext(), "Data saved be1" + Message4, Toast.LENGTH_SHORT).show();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //Message4 = sp4.getSelectedItem().toString();
                    Message5 = sp5.getSelectedItem().toString();
                    Message6 = sp6.getSelectedItem().toString();
                    MESSAGE_TOTAL = "I am with: "+Message4 + " I am at: " +Message5 +" I am feeling: "+Message6+"\n";
                    //1. Create an object of the FileOutputStream class using the openFileOutput method.
                    //MODE_WORLD_READABLE Allows to write permission to all the applications
                    FileOutputStream fou = openFileOutput("text10.txt", MODE_APPEND);
                    //2. Get an object of the OutPutStreamWriter class using the FileOutputStream object.
                    OutputStreamWriter osw = new OutputStreamWriter(fou);
                    try {
                        //3. Write the data
                        osw.write(MESSAGE_TOTAL);
                        osw.flush();
                        osw.close();

                        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //4. For reading the data from the file, first you need to create an object of the FileInputStream class.
                    FileInputStream fis = openFileInput("text10.txt");
                    //5. Get an object of the InputStreamReader class .
                    InputStreamReader isr = new InputStreamReader(fis);
                    char[] data = new char[data_block];
                    final_data = "";
                    int size;
                    //there is 80 character, this size will return into the variable size
                    try {
                        while ((size = isr.read(data)) > 0) {
                            //copy each string of data in this string read_data
                            String read_data = String.copyValueOf(data, 0, size);
                            //attach each piece of read_data the final string
                            final_data += read_data;
                            data = new char[data_block];
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(context, SmokingTriggers.class);
                startActivity(intent);
            }
        });

        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // on I am with: spinner click add more to go to another activity
                if (position == 3) {
                    Intent intent = new Intent(context, addOtherSp4.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if( position == 5){
                    Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 8) {
                    Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

 //***************************************************************************/

        Random rand = new Random();

        int n = rand.nextInt(24)+1;           // Generate Random number between 1 to 45
        int n2 = rand.nextInt(29)+1;
        int n3 = rand.nextInt(7)+1;
        int n4 = rand.nextInt(3)+1;
        int n5 = rand.nextInt(3)+1;
        int n6 = rand.nextInt(3)+1;

        //Options for navigation from home
        // Recommendation ->> refactoring the eventListener on this class (SOLVED NOW)
        if( daysInBetween >= 0 && daysInBetween <= 6 ){
            switch(n){
                case 1: myMessage.setText("Don't feel bad if you had a cigarette. Figure out what made you smoke, and how you can keep yourself from smoking next time");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall);break;
                case 2: myMessage.setText("A slip is just a minor setback - you are not a failure. Renew your commitment to quitting.");
                    myPicture.setImageResource(R.drawable.istock_000015166696xsmall);break;
                case 3: myMessage.setText("You have choices about how to deal with stress. Smoking is not the only way. Check out the Crave Crushers page for more info.");
                    myPicture.setImageResource(R.drawable.istock_000008434523xsmall);break;
                case 4: myMessage.setText("It doesn't matter if you've been totally smoke-free since quitting. What matters is that you want to become an ex-smoker");
                    myPicture.setImageResource(R.drawable.istock_000002038361xsmall);break;
                case 5: myMessage.setText("Need some help? Call the quitline. For more information see the Quit Help page.");
                    myPicture.setImageResource(R.drawable.istock_000016562476xsmall);break;
                case 6: myMessage.setText("Sometimes we slip. Now you can be prepared if tempted again.");
                    myPicture.setImageResource(R.drawable.istock_000017588182xsmall1);break;
                case 7: myMessage.setText("Hang in there. No one said it would be easy, but they do say it's worth it.");
                    myPicture.setImageResource(R.drawable.istock_000018733740xsmall);break;
                case 8: myMessage.setText("There is no magic spell to quit smoking. But you can learn from your slips.");
                    myPicture.setImageResource(R.drawable.istock_000017588182xsmall1);break;
                case 9: myMessage.setText("Nicotine gum, lozenges, inhalers and patches can help you quit. Check out the QUIT HELP page.");
                    myPicture.setImageResource(R.drawable.istock_000008064630xsmall);break;
                case 10: myMessage.setText("Keep trying no matter what. It IS possible to quit for good.");
                    myPicture.setImageResource(R.drawable.istock_000018299284xsmall);break;
                case 11: myMessage.setText("You can live without cigarettes. You had to learn to walk before you could run.");
                    myPicture.setImageResource(R.drawable.istock_000013559073xsmall);break;
                case 12: myMessage.setText("60% of all Canadians who ever smoked are now smoke-free. You can be too!");
                    myPicture.setImageResource(R.drawable.istock_000015193090xsmall);break;
                case 13: myMessage.setText("Tomorrow is a new day. Take it one day at a time.");
                    myPicture.setImageResource(R.drawable.istock_000006527867xsmall);break;
                case 14: myMessage.setText("Quitting smoking can be hard. Keep getting the support you need and remind yourself of your reasons for quitting.");
                    myPicture.setImageResource(R.drawable.istock_000014997757xsmall);break;
                case 15: myMessage.setText("Using the nicotine patch and/or other quit aids can increase your chances of success. See the Quit Help page for more info.");
                    myPicture.setImageResource(R.drawable.istock_000008064630xsmall);break;
                case 16: myMessage.setText("One cigarette did not make you a smoker, and if you had a setback it will not make you a smoker again.");
                    myPicture.setImageResource(R.drawable.istock_000018462245xsmall);break;
                case 17: myMessage.setText("Learn to avoid triggers. Practice makes perfect. Check out who, where and why you smoke on the <em>My Progress </em>page.");
                    myPicture.setImageResource(R.drawable.istock_000015882326xsmall);break;
                case 18: myMessage.setText("Figure out what triggered your smoking and plan ways to deal with it next time. Check out who, where and why you smoked on the <em>My Progress </em>page. Keep trying.");
                    myPicture.setImageResource(R.drawable.istock_000018180137xsmall);break;
                case 19: myMessage.setText("Most people try a few times before successfully quitting. Each time you try, you are one step closer to being smoke-free.");
                    myPicture.setImageResource(R.drawable.istock_000018285723xsmall);break;
                case 20: myMessage.setText("Remember your reason for quitting... [give user's main reason for quitting]");
                    myPicture.setImageResource(R.drawable.istock_000008632546xsmall);break;
                case 21: myMessage.setText("Do not give up. Quit again. If it feels difficult, talk to a health care professional about what can help.");
                    myPicture.setImageResource(R.drawable.istock_000008064630xsmall);break;
                case 22: myMessage.setText("Fear not - you are your own destiny. You have what it takes to quit smoking.");
                    myPicture.setImageResource(R.drawable.istock_000017542528xsmall);break;
                case 23: myMessage.setText("A slip is not the end of the world, keep trying.");
                    myPicture.setImageResource(R.drawable.istock_000017588182xsmall1);break;
                case 24: myMessage.setText("Hang in there. No one said it would be easy, but they do say it's worth it.");
                    myPicture.setImageResource(R.drawable.istock_000018733740xsmall);break;}
        }
        else if( daysInBetween == 7){
            myMessage.setText("You quit for a week - way to go! Try again and check out the Handling Slips page for more info.");
            myPicture.setImageResource(R.drawable.istock_000019396482xsmall);
        }
        else if ( daysInBetween > 8 && daysInBetween <= 14 ){
            switch(n3){
                case 1: myMessage.setText("Sometimes it takes a few tries. Think why you slipped and make some changes.");
                    myPicture.setImageResource(R.drawable.istock_000014997757xsmall);break;
                case 2: myMessage.setText("Don't quit quitting. You can do it!");
                    myPicture.setImageResource(R.drawable.istock_000018180137xsmall);break;
                case 3: myMessage.setText("Keep trying no matter what. It IS possible to quit for good.");
                    myPicture.setImageResource(R.drawable.istock_000016350433xsmall);break;
                case 4: myMessage.setText("We all have bad days, and you will get through this. Check out the Crave Crushers page to help boost your mood - just don't smoke.");
                    myPicture.setImageResource(R.drawable.istock_000018180137xsmall);break;
                case 5: myMessage.setText("Think of the benefits you've already achieved from quitting and the positive changes you have made so far. Try and stay smoke-free.");
                    myPicture.setImageResource(R.drawable.istock_000017542528xsmall);break;
                case 6: myMessage.setText("Quitting smoking is not about what you are giving up, it's about what you are gaining. Remember your reasons for quitting.");
                    myPicture.setImageResource(R.drawable.istock_000011957632xsmall);break;
                case 7: myMessage.setText("Read about other ways to quit smoking. See the Quit Help page for more information.");
                    myPicture.setImageResource(R.drawable.istock_000017465619small);break;
            }
        }
        else if ( daysInBetween > 15 && daysInBetween < 21 )
        {
            myMessage.setText("Challenge all of your negative thoughts. Smoking does not solve problems.");
            myPicture.setImageResource(R.drawable.istock_000011899337xsmall);
        }
        else if ( daysInBetween == 21){
            myMessage.setText("3 weeks smoke-free - way to go! Try again and check out the Handling Slips page for more info.");
            myPicture.setImageResource(R.drawable.istock_000019396482xsmall);
        }

        else if (daysInBetween >= 22 && daysInBetween <= 28 ){
            myMessage.setText("Don't quit quitting.");
            myPicture.setImageResource(R.drawable.istock_000018180137xsmall);
        }
        else if ( daysInBetween2 == 0 /*before quit day*/)
        {
            switch(n2){
                case 1: myMessage.setText("Smoking while pregnant increases the risk of stillbirths and Sudden Infant Death Syndrome.");
                    myPicture.setImageResource(R.drawable.ctc13);break;
                case 2: myMessage.setText("Feel relaxed when you smoke? Nicotine is actually a chemical stimulant which means smokers are never truly relaxed when they smoke.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;
                case 3: myMessage.setText("Smoking while on the pill increases the risk of blood clots.");
                    myPicture.setImageResource(R.drawable.istock_000012053156xsmall);break;
                case 4: myMessage.setText("1 in 2 smokers will die of smoking-related diseases./n Of all cancers, lung cancer is the leading cause of death.");
                    myPicture.setImageResource(R.drawable.istock_000006897090xsmall);break;
                case 5: myMessage.setText("Value your future.\n As soon as you quit you start adding years to your life.");
                    myPicture.setImageResource(R.drawable.istock_000017596022xsmall1);break;
                case 6: myMessage.setText("Social smokers are more likely to become daily smokers than someone who doesn't smoke at all. Check out the Quit Help page for things to do instead of smoking.");
                    myPicture.setImageResource(R.drawable.istock_000008404965xsmall);break;
                case 7: myMessage.setText("The next time you have a craving, do something else for 5 minutes or skip the cigarette entirely. Think of it as practice for your quit day.");
                    myPicture.setImageResource(R.drawable.istock_000008434523xsmall);break;
                case 8: myMessage.setText("Tobacco use kills more people than AIDS, alcohol, car accidents, murders, suicides, drugs, and fires combined");
                    myPicture.setImageResource(R.drawable.istock_000017312668xsmall);break;
                case 9: myMessage.setText("Marijuana is not a safe alternative to cigarette smoking. It may make you more likely to relapse. Check out the Quit Help page for more info.");
                    myPicture.setImageResource(R.drawable.istock_000009278592xsmall);break;
                case 10: myMessage.setText("Fatal heart attacks are 4 times more common in young men who smoke (vs. those who don't smoke).");
                    myPicture.setImageResource(R.drawable.istock_000009984021xsmall);break;
                case 11: myMessage.setText("Let your brain breathe. Cigarettes constrict blood vessels, arteries and veins, depriving the brain of oxygen.");
                    myPicture.setImageResource(R.drawable.istock_000011899337xsmall);break;
                case 12: myMessage.setText("What makes you smoke? Stress, Boredom, Alcohol, Social Situations. Use the app to record the people, places and emotions that trigger your smoking");
                    myPicture.setImageResource(R.drawable.istock_000016519803xsmall);break;
                case 13: myMessage.setText("Did you know that there are many myths about nicotine replacement therapy (patch, gum, etc.)\n Check out the Quit Help page for information about NRT.");
                    myPicture.setImageResource(R.drawable.istock_000016624768xsmall);break;
                case 14: myMessage.setText("Trying to quit with someone is proven to make you more likely to successfully quit.It helps to have someone to share experiences & tips with.");
                    myPicture.setImageResource(R.drawable.istock_000017329893xsmall);break;
                case 15: myMessage.setText("There is no such thing as 'light' or 'mild' cigarettes. Smokers drag harder on 'light' cigarettes and get the same level of tar and nicotine as they would from regular cigarettes.");
                    myPicture.setImageResource(R.drawable.istock_000008064630xsmall);break;
                case 16: myMessage.setText("Smoking causes a loss in your ability to taste and smell. When you quit, the damage done is 100% reversible. Food will taste awesome again!");
                    myPicture.setImageResource(R.drawable.istock_000016392611xsmall);break;
                case 17: myMessage.setText("When you quit, your clothes, hair and breath will smell better.");
                    myPicture.setImageResource(R.drawable.istock_000016603652xsmall);break;
                case 18: myMessage.setText("Quitting means more money in your wallet. How much? After you quit, check out your homepage to see how much you&rsquo;ve saved.");
                    myPicture.setImageResource(R.drawable.istock_000003060889xsmall);break;
                case 19: myMessage.setText("Smoking causes premature aging and wrinkling of the skin.");
                    myPicture.setImageResource(R.drawable.istock_000016603652xsmall);break;
                case 20: myMessage.setText("Smoking increases the risk of breast cancer at a younger age.");
                    myPicture.setImageResource(R.drawable.istock_000017301002xsmall);break;
                case 21: myMessage.setText("Smoking increases the chance that you won't be able to 'get it up' sometimes.");
                    myPicture.setImageResource(R.drawable.istock_000005325863xsmall);break;
                case 22: myMessage.setText("Smoking increases the risk of testicular cancer. The cure could involve removing one of your testicles.");
                    myPicture.setImageResource(R.drawable.istock_000016942580xsmall);break;
                case 23: myMessage.setText("Make a quit plan. If you haven't already set a quit date, set one using the app and start changing your routines now to get ready for the quit date.");
                    myPicture.setImageResource(R.drawable.istock_000017115710xsmall);break;
                case 24: myMessage.setText("Be prepared for quitting. Learn what to expect after you smoke your last cigarette. Check out the Cravings & Withdrawals page for more info.");
                    myPicture.setImageResource(R.drawable.istock_000017465619small);break;
                case 25: myMessage.setText("Being addicted to nicotine does not mean you can't stop smoking. You <em>can</em> do it!");
                    myPicture.setImageResource(R.drawable.istock_000016913681xsmall1);break;
                case 26: myMessage.setText("Make a list of the reasons you want to be smoke-free and record them in your profile to help motivate you.");
                    myPicture.setImageResource(R.drawable.istock_000016519803xsmall);break;
                case 27: myMessage.setText("Imagine yourself as a non-smoker.");
                    myPicture.setImageResource(R.drawable.istock_000018462245xsmall);break;
                case 28: myMessage.setText("If you haven't already, think about picking a quit date. Pick a time that won't be stressful - it's probably not a good idea to try and quit during exams or when you're really busy at work.");
                    myPicture.setImageResource(R.drawable.istock_000017115710xsmall);break;
                case 29: myMessage.setText("Talk to your doctor or a health professional about quitting. They can give you the facts and help you decide what option is best for you. Plus, speaking to a health professional makes you more likely to succeed.");
                    myPicture.setImageResource(R.drawable.istock_000016624768xsmall);break;
            }
        }
        else if (daysInBetween == 29 /* last day to quit */){
            switch(n4){
                case 1:myMessage.setText("Today is your last day as a smoker. Yeah! Review your quit plan. Smoke your <strong>very last</strong> cigarette.");
            myPicture.setImageResource(R.drawable.istock_000015193090xsmall);break;
                case 2:myMessage.setText("Use the My Progress page to help you slowly reduce the number of cigarettes you smoke.");
                    myPicture.setImageResource(R.drawable.istock_000016193458xsmall);break;
                case 3:myMessage.setText("Prepare a smoke-free space to live in. Throw out all lighters, matches, and ashtrays, even the ones in your car!");
                    myPicture.setImageResource(R.drawable.istock_000014764281xsmall);break;
        }}
        else if ( daysInBetween == 28 ){
            switch( n6 ){
                case 1: myMessage.setText("Make a list of the reasons you want to be smoke-free and enter your most important reason on the My Quit Plan page to help motivate you.");
                    myPicture.setImageResource(R.drawable.istock_000016519803xsmall);break;
                case 2: myMessage.setText("Your quit plan should include cutting back on coffee/caffeine. The amount of caffeine in your system can double when you quit because nicotine reduces the uptake of caffeine. You don't need those caffeine jitters when you're quitting.");
                    myPicture.setImageResource(R.drawable.istock_000018180560xsmall);break;
                case 3: myMessage.setText("Announcing plans to quit makes you more successful.\n Let your friends and family know your plans by sharing on Facebook or Twitter. The app can do this for you.");
                    myPicture.setImageResource(R.drawable.btnfacebookicon);break;
            }
        }
        else if(daysInBetween == 27){
            switch(n5){
                case 1:myMessage.setText("Pick at least one person you know who will support you in your quit and record them on the My Quit Plan page as your QUIT BUDDY.");
            myPicture.setImageResource(R.drawable.istock_000007714091xsmall);break;

                case 2:myMessage.setText("Keep track of your smoking. Record the people, places and emotions associated with each cigarette smoked when you hit the SMOKE button.");
            myPicture.setImageResource(R.drawable.istock_000016519803xsmall);break;

                case 3:myMessage.setText("Plan how you will deal with people, places and situations that might trigger you to smoke. Check out the Handling Triggers page for more info.");
            myPicture.setImageResource(R.drawable.istock_000014107730xsmall);break;
        }}
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();

        //addListenerOnSmokingTriggers();
    }
    public void addListenerOnSmokingTriggers(){
        final Context context = this;
        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(context, SmokingTriggers.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smoke, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Save screen state when orientation changes
    //this method is called before change orientation, so we can preserve values
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("FINAL_DATA", final_data);


    }
    //Display values in UI that were saved right before orientation changed and save
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        final_data = saveInstanceState.getString("FINAL_DATA");

    }
    private void saveData6() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("DATA_FINALSP4", final_dataSP4);

        editor.commit();
    }
    private void loadData6() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        final_dataSP4 = sp.getString("FINAL_DATASP4", final_dataSP4);

    }
    protected void onPause() {
        super.onPause();
        saveData6();

    }

    //@Override
    protected void onResume() {
        super.onResume();
        loadData6();
    }
}


