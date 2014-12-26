package ege493.sunynp.hawksnest2014;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class AddEditRA extends Fragment
{
   // callback method implemented by MainActivity  
   public interface AddEditRAListener
   {
      // called after edit completed so contact can be redisplayed
      public void onAddEditCompleted(long rowID);
   }
   
   private AddEditRAListener listener; 
   
   private long rowID; // database row ID of the contact
   private Bundle contactInfoBundle; // arguments for editing a contact

   // EditTexts for contact information
   private EditText nameEditText;
   private EditText dormEditText;
   private EditText roomEditText;
   private EditText extEditText;


   // set AddEditFragmentListener when Fragment attached   
   @Override
   public void onAttach(Activity activity)
   {
      super.onAttach(activity);
      listener = (AddEditRAListener) activity; 
   }

   // remove AddEditFragmentListener when Fragment detached
   @Override
   public void onDetach()
   {
      super.onDetach();
      listener = null; 
   }
   
   // called when Fragment's view needs to be created
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
   {
      super.onCreateView(inflater, container, savedInstanceState);    
      setRetainInstance(true); // save fragment across config changes
      setHasOptionsMenu(true); // fragment has menu items to display
      
      // inflate GUI and get references to EditTexts
      View view = 
         inflater.inflate(R.layout.frag_addeditra, container, false);
      nameEditText = (EditText) view.findViewById(R.id.nameEditText);
      dormEditText = (EditText) view.findViewById(R.id.dormEditText);
      roomEditText = (EditText) view.findViewById(R.id.roomEditText);
      extEditText = (EditText) view.findViewById(R.id.extEditText);

      contactInfoBundle = getArguments(); // null if creating new contact

      if (contactInfoBundle != null)
      {
         rowID = contactInfoBundle.getLong(MainActivity.ROW_ID);
         nameEditText.setText(contactInfoBundle.getString("name"));  
         dormEditText.setText(contactInfoBundle.getString("dorm"));  
         roomEditText.setText(contactInfoBundle.getString("room"));  
         extEditText.setText(contactInfoBundle.getString("ext"));  
      } 
      
      // set Save Contact Button's event listener 
      Button saveContactButton = 
         (Button) view.findViewById(R.id.saveContactButton);
      saveContactButton.setOnClickListener(saveContactButtonClicked);
      return view;
   }

   // responds to event generated when user saves a contact
   OnClickListener saveContactButtonClicked = new OnClickListener() 
   {
      @Override
      public void onClick(View v) 
      {
         if (nameEditText.getText().toString().trim().length() != 0)
         {
            // AsyncTask to save contact, then notify listener 
            AsyncTask<Object, Object, Object> saveContactTask = 
               new AsyncTask<Object, Object, Object>() 
               {
                  @Override
                  protected Object doInBackground(Object... params) 
                  {
                     saveContact(); // save contact to the database
                     return null;
                  } 
      
                  @Override
                  protected void onPostExecute(Object result) 
                  {
                     // hide soft keyboard
                     InputMethodManager imm = (InputMethodManager) 
                        getActivity().getSystemService(
                           Context.INPUT_METHOD_SERVICE);
                     imm.hideSoftInputFromWindow(
                        getView().getWindowToken(), 0);

                     listener.onAddEditCompleted(rowID);
                  } 
               }; // end AsyncTask
               
            // save the contact to the database using a separate thread
            saveContactTask.execute((Object[]) null); 
         } 
         else // required contact name is blank, so display error dialog
         {
            DialogFragment errorSaving = 
               new DialogFragment()
               {
                  @Override
                  public Dialog onCreateDialog(Bundle savedInstanceState)
                  {
                     AlertDialog.Builder builder = 
                        new AlertDialog.Builder(getActivity());
                     builder.setMessage(R.string.error_message);
                     builder.setPositiveButton(R.string.ok, null);                     
                     return builder.create();
                  }               
               };
            
            errorSaving.show(getFragmentManager(), "error saving contact");
         } 
      } // end method onClick
   }; // end OnClickListener saveContactButtonClicked

   // saves contact information to the database
   private void saveContact() 
   {
      // get RADatabaseConnector to interact with the SQLite database
      RADatabaseConnector databaseConnector = 
         new RADatabaseConnector(getActivity());

      if (contactInfoBundle == null)
      {
         // insert the contact information into the database
         rowID = databaseConnector.insertContact(
            nameEditText.getText().toString(),
            dormEditText.getText().toString(), 
            roomEditText.getText().toString(), 
            extEditText.getText().toString());
      } 
      else
      {
         databaseConnector.updateContact(rowID,
            nameEditText.getText().toString(),
            dormEditText.getText().toString(), 
            roomEditText.getText().toString(), 
            extEditText.getText().toString());
      }
   } // end method saveContact
} // end class AddEditFragment