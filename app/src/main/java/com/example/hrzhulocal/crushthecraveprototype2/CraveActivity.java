package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class CraveActivity extends MainActivityHome {
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crave);

        final ImageView myPicture = (ImageView) findViewById(R.id.imageView);
        final TextView myMessage = (TextView) findViewById(R.id.textView8);
        final TextView myMoneySaved = (TextView) findViewById(R.id.textView9);
        final TextView myButtonDistractMe = (TextView) findViewById(R.id.button);

        Random rand = new Random();

        int n = rand.nextInt(47)+1;           // Generate Random number between 1 to 45
        int n2 = rand.nextInt(4)+1;
        int n3 = rand.nextInt(2)+1;
        int n4 = rand.nextInt(17)+1;
        int n5 = rand.nextInt(13)+1;
        int n6 = rand.nextInt(29)+1;

        Toast.makeText(getApplicationContext(), "daysInBetween is  " + daysInBetween, Toast.LENGTH_LONG).show();

        if(daysInBetween >= 0 && daysInBetween <= 6){
            switch(n){
                case 1: myMessage.setText("If you think you need more help call your local quitline. For more information see the Quit Help page.");
                    myPicture.setImageResource(R.drawable.istock_000018110696xsmall);break;
                case 2: myMessage.setText("Take some deep breaths. A craving will only last a few minutes and then go away. You can beat it.");
                    myPicture.setImageResource(R.drawable.istock_000002038361xsmall); break;
                case 3: myMessage.setText("You are addicted to nicotine and your body is used to smoking. The bad feelings will go away");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;
                case 4: myMessage.setText("Nicotine gum, lozenges, inhalers and patches can help you quit. Check out the QUIT HELP page");
                    myPicture.setImageResource(R.drawable.istock_000016562476xsmall);break;
                case 5: myMessage.setText("You can do this, you are stronger than you think");
                    myPicture.setImageResource(R.drawable.istock_000016913681xsmall1);break;
                case 6: myMessage.setText("Cravings are a normal part of the quitting process. This is your body getting back to normal");
                    myPicture.setImageResource(R.drawable.istock_000018496949xsmall);break;
                case 7: myMessage.setText("Try using sugarless gum, mints, toothpicks, straws or sunflower seeds to keep your mouth busy.");
                    myPicture.setImageResource(R.drawable.istock_000017490436xsmall);break;
                case 8: myMessage.setText("Take a time out and relax. Take a nap, shower, run or scream. Do something good for you; just don't smoke.");
                    myPicture.setImageResource(R.drawable.istock_000013559073xsmall);break;
                case 9: myMessage.setText("Cravings are their worst after 2-3 days, then they back off. Take it a day at a time");
                    myPicture.setImageResource(R.drawable.istock_000014997757xsmall);break;
                case 10: myMessage.setText("Even the strongest craving will go away after a few minutes. Think of something else and remember why you want to be smoke-free.");
                    myPicture.setImageResource(R.drawable.istock_000011957632xsmall);break;
                case 11: myMessage.setText("Cravings will get weaker and less frequent with every day you don't smoke.");
                    myPicture.setImageResource(R.drawable.istock_000011899337xsmall);break;
                case 12: myMessage.setText("Smoking is like a bad relationship. You have to know when to walk away.");
                    myPicture.setImageResource(R.drawable.istock_000018462245xsmall);break;

                case 13: myMessage.setText("When you have a craving that seems to last forever, get out of the moment, leave the situation until the craving stops.");
                    myPicture.setImageResource(R.drawable.istock_000015882326xsmall);break;

                case 14: myMessage.setText("You are in control, not the addiction.");
                    myPicture.setImageResource(R.drawable.istock_000002038361xsmall);break;

                case 15: myMessage.setText("If friends or family smoke, ask them not to smoke near you.");
                    /*myPicture.setImageResource(R.drawable.//istock_000015193090xsmall);*/break;

                case 16: myMessage.setText("Cigarettes do not make a party better. Stay strong and say no when offered a cigarette.");
                    myPicture.setImageResource(R.drawable.istock_000015193090xsmall);break;

                case 17: myMessage.setText("Think you can have only one puff? It will only feed your cravings and make them stronger.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;

                case 18: myMessage.setText("Keep busy, avoid favourite smoking spots and friends who smoke (just for now).");
                    myPicture.setImageResource(R.drawable.istock_000018462245xsmall);break;

                case 19: myMessage.setText("Keep staying strong and smoke-free. It may not be easy, but it is totally worth it.");
                    myPicture.setImageResource(R.drawable.istock_000014114646xsmall);break;

                case 20: myMessage.setText("Reinvent yourself as an ex-smoker.");
                    myPicture.setImageResource(R.drawable.istock_000016913681xsmall1);break;

                case 21: myMessage.setText("Withdrawal symptoms can be strong during the first few days of quitting, but they are temporary.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;

                case 22: myMessage.setText("Remember your reason for staying smokefree: [give users' main reason for quitting]");
                    myPicture.setImageResource(R.drawable.istock_000008632546xsmall);break;

                case 23: myMessage.setText("When you're in your car, instead of smoking chew gum, sip water, listen to your favourite music.");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall);break;

                case 24: myMessage.setText("Within days of quitting your risk of heart disease, cancer and respiratory illness have decreased");
                    myPicture.setImageResource(R.drawable.istock_000016193458xsmall);break;

                case 25: myMessage.setText("When you're on the patio at the bar, drink non-alcoholic drinks and sip your drink slowly");
                    myPicture.setImageResource(R.drawable.istock_000007714091xsmall);break;

                case 26: myMessage.setText("If your roommate smokes, ask them to smoke outside.");
                    myPicture.setImageResource(R.drawable.istock_000008404965xsmall);break;

                case 27: myMessage.setText("After a meal, stay busy by brushing your teeth or washing the dishes");
                    myPicture.setImageResource(R.drawable.istock_000016392611xsmall);break;

                case 28: myMessage.setText("Since you quit you don't have to stand outside by yourself in the cold rain to light up.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;

                case 29: myMessage.setText("Since you quit you have more energy and endurance.");
                    myPicture.setImageResource(R.drawable.istock_000015193090xsmall);break;

                case 30: myMessage.setText("Since you've quit your home and car smell and look better.");
                    myPicture.setImageResource(R.drawable.istock_000016603652xsmall);break;

                case 31: myMessage.setText("First thing in the morning, jump in the shower right away and then eat a healthy breakfast.");
                    myPicture.setImageResource(R.drawable.istock_000016392611xsmall);break;

                case 32: myMessage.setText("If you smoke with your coffee, try skipping the coffee. Drink fruit juice, water or tea instead.");
                    myPicture.setImageResource(R.drawable.istock_000018180560xsmall);break;

                case 33: myMessage.setText("Since you quit you've saved money. How much? Check out how much on your home page.");
                    myPicture.setImageResource(R.drawable.istock_000013224874xsmall);break;

                case 34: myMessage.setText("Remember other challenges you have mastered.");
                    myPicture.setImageResource(R.drawable.istock_000014282884xsmall);break;

                case 35: myMessage.setText("Do something else with your hands: text your friends, read a book, or play with a coin. Check out the DISTRACT the CRAVE page for more ideas.");
                    myPicture.setImageResource(R.drawable.istock_000008434523xsmall);break;

                case 36: myMessage.setText("Do something else with your mouth: chew on sugarless gum, celery/carrot sticks, a straw, or sunflower seeds.");
                    myPicture.setImageResource(R.drawable.istock_000017490436xsmall);break;

                case 37: myMessage.setText("Splash some cold water on your face");
                    myPicture.setImageResource(R.drawable.istock_000017256227xsmall);break;

                case 38: myMessage.setText("Since you've quit your teeth aren't being stained yellowish-brown.");
                    myPicture.setImageResource(R.drawable.istock_000014282884xsmall);break;

                case 39: myMessage.setText("Feeling like crap is only temporary. Eventually quitting smoking will make you feel better.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;

                case 40: myMessage.setText("You know you made the right decision to quit. You can do it!");
                    myPicture.setImageResource(R.drawable.istock_000019564504xsmall);break;

                case 41: myMessage.setText("It's okay to substitute eating for smoking, but if you don't want to gain weight, eat healthy snacks. Check out the WEIGHT GAIN page for more info");
                    myPicture.setImageResource(R.drawable.istock_000017490436xsmall);break;

                case 42: myMessage.setText("In the beginning you may need to avoid alcohol, bars & parties. Socialize in non-smoking, non-drinking places like movies theatres and museums.");
                    myPicture.setImageResource(R.drawable.istock_000017595407xsmall);break;

                case 43: myMessage.setText("Running is as effective as the patch to help people quit smoking.");
                    myPicture.setImageResource(R.drawable.istock_000013559073xsmall);break;

                case 44: myMessage.setText("Exercise can reduce stress and keep your weight down. It also makes you feel good and improves your health.");

                    myPicture.setImageResource(R.drawable.istock_000002311855xsmall);break;
                case 45: myMessage.setText("Drink some water, exercise, visit &lt;a href=\"http://www.quitrunchill.org\"&gt;www.quitrunchill.org.&lt;/a&gt;&nbsp; Check out Quit Help page for the link.");
                    myPicture.setImageResource(R.drawable.istock_000017523599xsmall);break;

                case 46: myMessage.setText("Your doctor can suggest ways to control cravings. See the Quit Help page.");
                    myPicture.setImageResource(R.drawable.istock_000016624768xsmall);break;

                case 47: myMessage.setText("Stay positive. Call a friend or your Quit Buddy.");
                    myPicture.setImageResource(R.drawable.istock_000018110696xsmall);break;

                case 48: myMessage.setText("Smoking causes you to lose your ability to taste and smell. Quitting reverses the damage. Food will taste awesome!");
                    myPicture.setImageResource(R.drawable.istock_000016392611xsmall);break;

                case 49: myMessage.setText("Quitting means your clothes, hair and breath will smell better.");
                    myPicture.setImageResource(R.drawable.istock_000016603652xsmall);break;

                case 50: myMessage.setText("Think of ways to reward yourself for not smoking: buy new music for your iPod or a magazine");
                    myPicture.setImageResource(R.drawable.istock_000003060889xsmall);break;

                case 51: myMessage.setText("Feeling anxious and jittery? Cut down on caffeine. The amount of caffeine can double when you quit because nicotine reduces the uptake of caffeine.");
                    myPicture.setImageResource(R.drawable.istock_000011728008xsmall);break;

                case 52: myMessage.setText("What can you do instead of smoking? Slow down and enjoy the day - don't rush.");
                    myPicture.setImageResource(R.drawable.istock_000017482182xsmall);break;

                case 53: myMessage.setText("What can you do instead of smoking? Get some exercise; go to the gym or play a sport");
                    myPicture.setImageResource(R.drawable.istock_000008434523xsmall);break;

                case 54: myMessage.setText("Instead of smoking, reward yourself by going to a movie with the money you saved from not smoking.");
                    myPicture.setImageResource(R.drawable.istock_000016771803xsmall);break;

                case 55: myMessage.setText("What can you do instead of smoking? Deep breathe or meditate; learn to cook something new.");
                    myPicture.setImageResource(R.drawable.istock_000016392611xsmall);break;

                case 56: myMessage.setText("What can you do instead of smoking? Check out the Crave Crushers page for options.");
                    myPicture.setImageResource(R.drawable.istock_000016767002xsmall);break;

                case 57: myMessage.setText("What can you do instead of smoking? Check out the Crave Crushers page for options.");
                    myPicture.setImageResource(R.drawable.istock_000017993312xsmall);break;
            }
        }
        else if (daysInBetween == 7 ){
            myMessage.setText("Congratulations you have quit for one week. You can keep it going. Reward yourself");
            myPicture.setImageResource(R.drawable.istock_000019396482xsmall);
        }
        else if ( daysInBetween > 8 && daysInBetween <= 14 ) {
            switch(n5){
                case 1: myMessage.setText("Smoking won't solve the problem or make the stress go away. Tell your quit buddy or a friend you are having a craving.");
                    myPicture.setImageResource(R.drawable.istock_000017329893xsmall);break;
                case 2: myMessage.setText("Have you rewarded yourself for not smoking? Use the money you've saved for a movie or dinner out.");
                    myPicture.setImageResource(R.drawable.istock_000016147210xsmall);break;
                case 3: myMessage.setText("Quitting smoking is not about what you are giving up it's about what you are gaining. Remember your reasons for quitting.");
                    myPicture.setImageResource(R.drawable.istock_000011957632xsmall);break;
                case 4: myMessage.setText("I am strong. I am committed. I will beat this habit.");
                    myPicture.setImageResource(R.drawable.istock_000016913681xsmall1);break;
                case 5: myMessage.setText("If you think you need more help call your local quitline. Check out the Quit Help page for more info.");
                    myPicture.setImageResource(R.drawable.istock_000016562476xsmall);break;
                case 6: myMessage.setText("NRT (patch, gum, etc.,) takes time to work. Make sure you follow the instructions on the package.");
                    myPicture.setImageResource(R.drawable.istock_000014504400xsmall);break;
                case 7: myMessage.setText("Remember the 4 Do's - Distract, Delay, Deep Breathing, Drink Water.");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall);break;
                case 8: myMessage.setText("Think you can have only one puff? It will only feed your cravings and make them stronger.");
                    myPicture.setImageResource(R.drawable.istock_000002871599xsmall);break;
                case 9: myMessage.setText("Think of the benefits of quitting and the positive changes you have made so far. A craving will only last a few minutes then will go away");
                    myPicture.setImageResource(R.drawable.istock_000002311855xsmall);break;
                case 10: myMessage.setText("Who else are you giving up smoking for? Write down 4 people who will be glad that you are smoke-free.");
                    myPicture.setImageResource(R.drawable.ctc8);break;
                case 11: myMessage.setText("Celebrate each time you beat a craving. Reward yourself with some of the money you didn't spend on cigarettes.");
                    myPicture.setImageResource(R.drawable.istock_000003060889xsmall);break;
                case 12: myMessage.setText("Each day that passes, your addiction gets weaker and weaker and YOU get stronger and stronger.");
                    myPicture.setImageResource(R.drawable.istock_000017115710xsmall);break;
                case 13: myMessage.setText("Imagining yourself smoke-free is a powerful way to increase your confidence in your ability to quit smoking.");
                    myPicture.setImageResource(R.drawable.istock_000017542528xsmall);break;
            }
        }
        else if (daysInBetween == 14){
            myMessage.setText("Congratulations you have quit for two weeks. You can keep it going. Reward yourself!");
            myPicture.setImageResource(R.drawable.istock_000014504400xsmall);
        }
        else if (daysInBetween > 15 && daysInBetween <= 21){
          if(n2 == 1){myMessage.setText("Keep your list of reasons for quitting where you will always see it - on your fridge, bulletin board, or day planner.");
                myPicture.setImageResource(R.drawable.istock_000016495673xsmall);
          }
          else if(n2 == 2){myMessage.setText("Add being smoke-free to your list of accomplishments");
              myPicture.setImageResource(R.drawable.istock_000016339384xsmall);
          }
          else if (n2 == 3){myMessage.setText("Lung capacity increases by 30% after a few weeks without cigarettes. Use your healthy lungs to ride a bike or take a walk");
              myPicture.setImageResource(R.drawable.istock_000017993312xsmall);
          }
          else if (n2 == 4){myMessage.setText("Not smoking might make you feel like crap for a little while, but it won't kill you.");
              myPicture.setImageResource(R.drawable.istock_000017256227xsmall);
          }
      }
        else if (daysInBetween == 21){
            myMessage.setText("Congratulations you have quit for three weeks. You can keep it going. Reward yourself!");
            myPicture.setImageResource(R.drawable.istock_000019396482xsmall);
        }
        else if (daysInBetween > 22 && daysInBetween <= 28){
            switch(n4){
                case 1:myMessage.setText("Have you noticed that your taste buds are working better? Try some fresh fruit, veggies or sugarless gum.");
                    myPicture.setImageResource(R.drawable.istock_000017490436xsmall); break;

                case 2:myMessage.setText("Your health is improving. Your lungs are becoming clearer, your skin is fresher and your hair is shinier. It only gets better.");
                    myPicture.setImageResource(R.drawable.istock_000006527867xsmall); break;

                case 3:myMessage.setText("Hang out with non-smoking friends, in non-smoking places. When you're completely smoke-free you can hang with anyone, anywhere");
                    myPicture.setImageResource(R.drawable.istock_000016771803xsmall); break;

                case 4:myMessage.setText("Get lots of sleep to help fight cravings. If you get tired, you may become irritated and feel like a smoke.");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall); break;

                case 5:myMessage.setText("Try this relaxation method. Working up your body from your toes, contract each set of muscles for 4-5 seconds, then relax.");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall); break;

                case 6:myMessage.setText("Withdrawal symptoms happen because your body has stopped getting nicotine. They are good signs that your body is healing.");
                    myPicture.setImageResource(R.drawable.istock_000018496949xsmall); break;

                case 7:myMessage.setText("It may be a challenge to stay smoke-free, but you have made it this far and you should be proud. Check out the <em>My Awards<em> page");
                    myPicture.setImageResource(R.drawable.istock_000001717560xsmall); break;

                case 8:myMessage.setText("You are well on your way to a healthier new you.");
                    myPicture.setImageResource(R.drawable.istock_000013224874xsmall); break;

                case 9:myMessage.setText("You are on your way to being smoke-free. Stay strong.");
                    myPicture.setImageResource(R.drawable.istock_000018194596xsmall); break;

                case 10:myMessage.setText("How much money have you saved by not smoking? Check out your home page.");
                    myPicture.setImageResource(R.drawable.istock_000018254114xsmall); break;

                case 11:myMessage.setText("Even when you've come this far, triggers can sneak up on you. Look at who, where and why you smoked on the My Progress page.");
                    myPicture.setImageResource(R.drawable.istock_000016339384xsmall); break;

                case 12:myMessage.setText("Be proud to be a non-smoker.");
                    myPicture.setImageResource(R.drawable.istock_000018288577xsmall); break;

                case 13:myMessage.setText("By Day 25 most people's cravings start to fade.");
                    myPicture.setImageResource(R.drawable.istock_000019396482xsmall); break;

                case 14:myMessage.setText("Think about how good it will feel to show people who doubted you that you succeeded at quitting.");
                    myPicture.setImageResource(R.drawable.istock_000013224874xsmall); break;

                case 15:myMessage.setText("Have you noticed that you're not coughing as often? Just another benefit of being smoke-free.");
                    myPicture.setImageResource(R.drawable.istock_000002311855xsmall); break;

                case 16:myMessage.setText("The 5 largest tobacco companies spend more than $34 million a day convincing people to smoke. Imagine the positive things you could do with that money.");
                    myPicture.setImageResource(R.drawable.istock_000003060889xsmall); break;

                case 17:myMessage.setText("If you think you need more help call your local quitline. For more information see the Quit Help page");
                    myPicture.setImageResource(R.drawable.istock_000018110696xsmall); break;

            }
        }
        else if (daysInBetween > 28){

            if(n3 == 1){myMessage.setText("Don't forget how you've dealt with cravings. Call your local quitline if you need more help. See the Quit Help page");
                myPicture.setImageResource(R.drawable.istock_000018110696xsmall);
            }
            else{myMessage.setText("Congratulations you have quit for four weeks! You can keep it going. Check out the My Awards page, let your friends and social network know, and remember to reward yourself.");
                myPicture.setImageResource(R.drawable.istock_000001717560xsmall);
            }
        }
        else if ( daysInBetween2 == 0 /*before quit day*/)
        {
            switch(n6){
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
        NumberFormat formatter = new DecimalFormat("#0.00");

        myMoneySaved.setText("You have saved $"+ formatter.format(moneySavedTotal) +" in total!");
        myMessage.refreshDrawableState();
        //Options for navigation from home
        // Recommendation ->> refactoring the eventListener on this class (SOLVED NOW)
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();
        addListenerOnDistractMe();
    }

    private void addListenerOnDistractMe(){
        final Context context = this;
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(context, DistractMe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crave, menu);
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
}