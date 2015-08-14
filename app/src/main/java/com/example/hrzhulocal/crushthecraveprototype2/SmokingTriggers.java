package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SmokingTriggers extends SmokeActivity {

    public static boolean isFirstTimeOpen = true;

    public SmokingTriggers() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoking_triggers);

        TextView textView = (TextView) findViewById(R.id.textView23);
        addListenerOnHomeImageButton();
        addListenerOnAwardImageButton();
        addListenerOnProgressImageButton();
        addListenerOnQuitHelpImageButton();
        addListenerOnMoreImageButton();

        //textView.setText(final_data.substring(6).relace("^", "\n"));
        //If the string is empty
  //////////////      Toast.makeText(getApplicationContext(), "final_data " + final_data, Toast.LENGTH_LONG).show();

        if(final_data == null ) {
            //do nothing
        }
        else{
            textView.setText(final_data.replace("^", "\n"));
        }
        /*LinkedList theLinkedList = new LinkedList();

        if(final_data == null){
            theLinkedList.prepend(MESSAGE_TOTAL);
        }
        else{
            theLinkedList.append(MESSAGE_TOTAL);
        }*/
        //textView.setText("entry 1 "+theLinkedList.Head);
  //////////////////      Toast.makeText(getApplicationContext(), "size of linked list " + LinkedListCount, Toast.LENGTH_LONG).show();
    }
    private void saveData2() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("ISFIRSTTIMEOPEN", isFirstTimeOpen);
        editor.commit();
    }

    private void loadData2() {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        isFirstTimeOpen = sp.getBoolean("ISFIRSTTIMEOPEN", isFirstTimeOpen);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData2();
    }

    /**
     * Created by hrzhulocal on 28/07/2015.
     * Demonstrated the use of Linked List
     */
    static class LinkedList{

        public SmokeActivity Head;
        public SmokeActivity Tail;
        public SmokeActivity Current;
        public SmokeActivity temp;

        //Constructor
        LinkedList(){
            Head = null;
            Tail = null;
            Current = null;
        }
        //public LinkedList(String triggerEntry) {
        //    super(triggerEntry);
        //}
        public boolean isEmpty(){
            return(Current == null);
        }
        public static boolean isTriggerFull(){
            if(LinkedListCount >= 18){
                return true;
            }else{
                return false;
            }
        }
        //return the size of the linked list
        public int append(String triggerEntry){
            //traverse to the end of linked list
            //for(LinkedListCount = 0; !isEmpty(); LinkedListCount++)
            /*SmokeActivity.LinkedListCount = 0;
            while(!isEmpty())
            {
                SmokeActivity.LinkedListCount++;
                Current = Current.next;
            }*/
            for(LinkedListCount = previousLinkedListCount; !isEmpty(); LinkedListCount++) {
                Current = Current.next;
            }
            //assign a new node to the end
            Current = (new SmokeActivity(triggerEntry));
            Tail = Current;
            //update previousLinkedListCount
            previousLinkedListCount = LinkedListCount;
            return (LinkedListCount);
        }

        /*public int append2(String triggerEntry){
            SmokeActivity newLink = new SmokeActivity(triggerEntry);
            if(Current == null)
            {
                Current = newLink;
            }
            else{
                newLink.next;
            }
        }*/
        /*public void append(String triggerEntry){
            //traverse to the end of linked list
            for(LinkedListCount = 0; triggerEntry.next() != null; LinkedListCount++)
            {
                Current = Current.next;
            }
            //assign a new node to the end
            Current = new SmokeActivity(triggerEntry);
        }*/
        //public void prepend(String triggerEntry){
        //   Current = new SmokeActivity(triggerEntry);
        //}
        //public static int Count (){
        //    for(LinkedListCount = 0; !isEmpty();)
        //    return LinkedListCount;
        //}
        public void prepend(String triggerEntry){
            temp = new SmokeActivity(triggerEntry);

            //connect the the first ink field stored inside the linked list to newLinke
            //it's Next is assigned the reference to the previous Link created
            temp.next = Current;

            //address
            //the LinkedList's firstLink is assigned to a reference to the newest Link added
            Current = temp;
            Head = temp;
        }
        public SmokeActivity removeLastLink(String triggerEntry){
            SmokeActivity linkedListRef = Current;
            while(!isEmpty()){
                //traverse the linked list
                Current = Current.next;
            }
            //firstLink is assigned the value of the current firstLink's next
            return linkedListRef;
        }
        /* public void display(){
             SmokeActivity theLink = Current;
             while(theLink != null){
                 theLink.display();
                 System.out.println("Next Link: " + theLink.next);
                 theLink = theLink.next;
                 System.out.println();
             }
         }*/
        public SmokeActivity find(String triggerEntry){
            SmokeActivity theLink = Current;
            if(!isEmpty()){
                while(theLink.triggerEntry != triggerEntry)
                {
                    //check if at the end of the LinkedList
                    if(theLink.next == null)
                    {
                        Tail = theLink;
                        //reach the tail of a linked list
                        return null;
                    }
                    else
                    {
                        //found a match
                        theLink = theLink.next;
                    }
                }
            }else{
                System.out.println("Empty LinkedList");
            }
            return theLink;
        }
    }
}