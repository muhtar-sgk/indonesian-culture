package org.saungit.indonesianculture;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.saungit.indonesianculture.adapter.CategoryAdapter;
import org.saungit.indonesianculture.model.Category;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class CategoryActivity extends AppCompatActivity {
    private FeatureCoverFlow mCoverFlow;
    private CategoryAdapter mAdapter;
    private ArrayList<Category> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        
        setContentView(R.layout.activity_category);

        mData.add(new Category(R.drawable.alat_musik, R.string.alat_musik));
        mData.add(new Category(R.drawable.cerita_rakyat, R.string.cerita_rakyat));
        mData.add(new Category(R.drawable.makanan_minuman, R.string.makanan_minuman));
        mData.add(new Category(R.drawable.motif_kain, R.string.motif_kain));
        mData.add(new Category(R.drawable.musik_dan_lagu, R.string.musik_dan_lagu));
        mData.add(new Category(R.drawable.naskah_kuno_dan_prasasti, R.string.naskah_kuno_dan_prasasti));
        mData.add(new Category(R.drawable.ornamen, R.string.ornamen));
        mData.add(new Category(R.drawable.pakaian_tradisional, R.string.pakaian_tradisional));
        mData.add(new Category(R.drawable.permainan_tradisional, R.string.permainan_tradisional));
        mData.add(new Category(R.drawable.produk_arsitektur, R.string.produk_arsitektur));
        mData.add(new Category(R.drawable.ritual, R.string.ritual));
        mData.add(new Category(R.drawable.seni_pertunjukan, R.string.seni_pertunjukan));
        mData.add(new Category(R.drawable.senjata_dan_alat_perang, R.string.senjata_dan_alat_perang));
        mData.add(new Category(R.drawable.tarian, R.string.tarian));
        mData.add(new Category(R.drawable.tata_cara_pengobatan, R.string.tata_cara));

        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CategoryActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CategoryAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CategoryActivity.this,
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
