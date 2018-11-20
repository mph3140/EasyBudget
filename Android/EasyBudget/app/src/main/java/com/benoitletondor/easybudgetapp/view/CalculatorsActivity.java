package com.benoitletondor.easybudgetapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.benoitletondor.easybudgetapp.R;

import java.util.ArrayList;

public class CalculatorsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int wordListSize = mWordList.size();
//                mWordList.addLast("+ Word " + wordListSize);
//                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
//                mRecyclerView.smoothScrollToPosition(wordListSize);
//            }
//        });

        //Bundle bundle = this.getIntent().getExtras();
        //ArrayList<String> searchResults = bundle.getStringArrayList("filteredList");

        ArrayList<String> calcList = new ArrayList<>();
        calcList.add("Monthly Payment Calc");
        calcList.add("New Calc 1");
        calcList.add("New Calc 2");

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, calcList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
