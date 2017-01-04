package com.example.user.dinamisku;

/**
 * Created by User on 03/01/2017.
 */
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by User on 01/01/2017.
 */

public class MyLayoutOperation {

    public static void add(final Activity activity, TextView btn)
    {

        final LinearLayout linearLayoutForm = (LinearLayout) activity.findViewById(R.id.linearLayoutForm);
        btn.setOnClickListener(new View.OnClickListener() {
            private Button sub,btnRemove,add;
            @Override
            public void onClick(View v) {
                final int[] counter = new int[1];
                final LinearLayout newView = (LinearLayout)activity.getLayoutInflater().inflate(R.layout.rowdetail, null);
                newView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                sub = (Button) newView.findViewById(R.id.sub);
                btnRemove = (Button) newView.findViewById(R.id.btnRemove);
                add = (Button) newView.findViewById(R.id.add);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView cot = (TextView) newView.findViewById(R.id.tvScore);

                        counter[0] += 1;

                        cot.setText(""+ counter[0]);

                    }
                });

                sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView cot = (TextView) newView.findViewById(R.id.tvScore);

                        counter[0] -= 1;

                        cot.setText(""+ counter[0]);
                    }
                });

                btnRemove.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        linearLayoutForm.removeView(newView);
                    }
                });
                linearLayoutForm.addView(newView);
            }
        });
    }
}
