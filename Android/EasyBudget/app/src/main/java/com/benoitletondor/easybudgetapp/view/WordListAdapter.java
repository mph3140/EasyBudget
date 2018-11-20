package com.benoitletondor.easybudgetapp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.benoitletondor.easybudgetapp.R;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final ArrayList<String> mWordList;
    private LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            String element = mWordList.get(mPosition);

            if (element.equals("Monthly Payment Calc")) {
                Intent intent1 = new Intent(view.getContext(), CalculateInterestActivity.class);
                view.getContext().startActivity(intent1);
            }
            //else if (element.equals("Jake Frommeyer")) {
//                Intent intent2 = new Intent(view.getContext(), details.class).putExtra("title", "Jake Frommeyer").putExtra("desc", "frommeyerj4@nku.edu");
//                view.getContext().startActivity(intent2);
//            } else if (element.equals("Garrett Foister")) {
//                Intent intent2 = new Intent(view.getContext(), details.class).putExtra("title", "Garrett Foister").putExtra("desc", "foisterg1@nku.edu");
//                view.getContext().startActivity(intent2);
//            } else if (element.equals("James Kennedy")) {
//                Intent intent2 = new Intent(view.getContext(), details.class).putExtra("title", "James Kennedy").putExtra("desc", "kennedyj16@nku.edu");
//                view.getContext().startActivity(intent2);
//            } else if (element.equals("Logan Vanway")) {
//                Intent intent2 = new Intent(view.getContext(), details.class).putExtra("title", "Logan Vanway").putExtra("desc", "wanwayl1@nku.edu");
//                view.getContext().startActivity(intent2);
//            } else if (element.equals("Joseph Wernke")) {
//                Intent intent2 = new Intent(view.getContext(), details.class).putExtra("title", "Joseph Wernke").putExtra("desc", "wernkej11@nku.edu");
//                view.getContext().startActivity(intent2);
//            }
        }
    }

    public WordListAdapter(Context context, ArrayList<String> wordList) {

        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {

        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
