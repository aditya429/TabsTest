package mapintegration.com.tabstest;

/**
 * Created by Aditya SMT on 17-05-2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class TabFragment3 extends Fragment {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private ImageView image;
  //  final View rootView;
    int tabPosition;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView =inflater.inflate(R.layout.tab_fragment_3, container, false);

        tabPosition = ((MainActivity) getActivity()).getTabPosition();

        if (tabPosition==2) {
            Toast.makeText(getActivity(),"selecteed "+tabPosition,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,
                    CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
        return rootView;

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // convert byte array to Bitmap

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

              //  image.setImageBitmap(bitmap);

            }
        }
    }


}