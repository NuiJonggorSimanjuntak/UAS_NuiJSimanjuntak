package nui.app.uas_NuiJSimanjuntak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import nui.app.uas_NuiJSimanjuntak.R;
import nui.app.uas_NuiJSimanjuntak.User;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList) {

        super(context, R.layout.list_item, userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {

        nui.app.uas_NuiJSimanjuntak.User user = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView userName = convertView.findViewById(R.id.personName);
        TextView lastMsg = convertView.findViewById(R.id.lastMessage);
        TextView time = convertView.findViewById(R.id.msgtime);

        imageView.setImageResource(user.imageId);
        userName.setText(user.name);
        lastMsg.setText(user.lasMessage);
        time.setText(user.lastMsgTime);

        return convertView;
    }

}
