package com.example.c0771910_w2020_mad3125_fp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.c0771910_w2020_mad3125_fp.model.Customer;

public class UserPrefs {
    /** This application's preferences label */
    private static final String PREFS_NAME = "com.our.package.UserPrefs";
    /** The prefix for flattened user keys */
    public static final String KEY_PREFIX =
            "com.our.package.KEY_customerId";
    /** generic field keys */
    private static final String KEY_firstName = "com.our.package.KEY_firstName";
    private static final String KEY_LastName = "com.our.package.KEY_LastName";
    private static final String KEY_emailId = "com.our.package.KEY_emailId";
    private static final String KEY_customerBills = "com.our.package.KEY_customerBills";


    /** This application's preferences */
    private static SharedPreferences settings;

    /** This application's settings editor*/
    private static SharedPreferences.Editor editor;

    /** Constructor takes an android.content.Context argument*/
    public UserPrefs(Context ctx){
        if(settings == null){
            settings = ctx.getSharedPreferences(PREFS_NAME,
                    Context.MODE_PRIVATE );
        }
        /*
         * Get a SharedPreferences editor instance.
         * SharedPreferences ensures that updates are atomic
         * and non-concurrent
         */
        editor = settings.edit();
    }


    private String getFieldKey(String Id, String fieldKey) {
        return  KEY_PREFIX + Id + "_" + fieldKey;
    }

    public void setUser(Customer customer){
        if(customer == null)
            return; // don't bother

        String id = customer.getCustomerId();
        editor.putString(
                getFieldKey(id, KEY_firstName),
                customer.getFirstName() );
        editor.putString(
                getFieldKey(id, KEY_LastName),
                customer.getLastName() );
        editor.putString(
                getFieldKey(id, KEY_emailId),
                customer.getEmailId() );
        editor.commit();
    }
    /** Retrieve */
    public Customer getUser(String id){
        String firstname = settings.getString(
                getFieldKey(id, KEY_firstName),
                "" ); // default value
        String lastname =  settings.getString(
                getFieldKey(id, KEY_LastName),
                ""); // default value
        String emailid =  settings.getString(
                getFieldKey(id, KEY_emailId),
                ""); // default value

        return new Customer(id, firstname, lastname, emailid);
    }

    /** Delete */
    public void deleteUser(Customer user){
        if(user == null)
            return; // don't bother

        String id = user.getCustomerId();
        editor.remove( getFieldKey(id, KEY_firstName) );
        editor.remove( getFieldKey(id, KEY_LastName) );
        editor.remove( getFieldKey(id, KEY_emailId) );

        editor.commit();
    }


}
