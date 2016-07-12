package in.silive.happybirthday;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by akriti on 24/2/16.
 */
public class ListAdapter extends BaseAdapter{

        String[]result = {};
        Integer[]id={};
        public Context context;
        private static LayoutInflater inflater=null;
        MainActivity m;

    public class Holder{
            TextView name;
            ImageView img;

        }


        public ListAdapter(MainActivity mainActivity,String[] strings,Integer[] integer){

            id=integer;
            result=strings;
            context=mainActivity;
            m=mainActivity;


            inflater=(LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final Holder holder=new Holder();

            View row_view;
            row_view=inflater.inflate(R.layout.list_adapter,null);
            holder.name=(TextView)row_view.findViewById(R.id.name);
            holder.img=(ImageView)row_view.findViewById(R.id.img);
            holder.img.setImageResource(id[position]);
            holder.name.setText(result[position]);
            row_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    m.display(position);

                }
            });
            return row_view;

        }
    }



