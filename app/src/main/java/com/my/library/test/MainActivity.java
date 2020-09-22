package com.my.library.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.common.library.util.RetrofitUtil;
import com.common.library.util.SpaceItemDecoration;
import com.common.library.view.ViewPager;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<LocalMedia> list;

    private String path = "/storage/emulated/0/DCIM/Camera/VID_20200917_15090740.mp4";

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api api = RetrofitUtil.getInstance("https://api.njddxh.com/").getRetrofit().create(Api.class);
                Call<VersionBack> call = api.updateVersion("11100", "1000");
                call.enqueue(new Callback<VersionBack>() {
                    @Override
                    public void onResponse(Call<VersionBack> call, Response<VersionBack> response) {
                        Log.e(".......", response.code() +"");
                    }

                    @Override
                    public void onFailure(Call<VersionBack> call, Throwable t) {

                    }
                });
            }
        });

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recycler.addItemDecoration(SpaceItemDecoration.getGridItemDecoration());
        TestAdapter3 adapter3 = new TestAdapter3(getList());
        adapter3.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                ToastUtils.s(getApplicationContext(), position + "");
            }
        });
        recycler.setAdapter(adapter3);
    }

    public List<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < 100; i1++) {
            list.add(""+ i1);
        }
        return list;
    }
}