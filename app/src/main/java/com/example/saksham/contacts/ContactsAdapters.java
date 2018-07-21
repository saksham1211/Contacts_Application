package com.example.saksham.contacts;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by saksham on 21-07-2018.
 */

public class ContactsAdapters extends ArrayAdapter<Users> {

        private Activity context;
        private List<Users> UsersList;

        public ContactsAdapters(Activity context,List<Users>UsersList){
                super(context,R.layout.list_view, UsersList);
                this.context=context;
                this.UsersList = UsersList;

        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.list_view,null,true);

        TextView Name =(TextView)listview.findViewById(R.id.Name);
        TextView PhnNum =(TextView)listview.findViewById(R.id.PhnNum);

        Users user= UsersList.get(position);

        Name.setText(user.getName());
        PhnNum.setText(user.getPhone());

            return listview;

    }
}
