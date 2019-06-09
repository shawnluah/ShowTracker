package sg.edu.rp.c346.showtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowAdapter extends ArrayAdapter<Show> {

    private ArrayList<Show> show;
    private Context context;
    private TextView tvShowName, tvDate, tvGenre, tvLanguage;

    public ShowAdapter(Context context, int resource, ArrayList<Show> objects) {
        super(context, resource, objects);
        show = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvShowName = rowView.findViewById(R.id.tvShowName);
        tvDate = rowView.findViewById(R.id.tvShowDate);
        tvGenre = rowView.findViewById(R.id.tvShowGenre);
        tvLanguage = rowView.findViewById(R.id.tvLanguage);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Show currentShow = show.get(position);
        // Set the TextView to show the food

        tvShowName.setText(currentShow.getName());
        tvDate.setText(currentShow.getDate());
        tvGenre.setText(currentShow.getGenre());
        tvLanguage.setText(currentShow.getLanguage());

        return rowView;
    }
}
