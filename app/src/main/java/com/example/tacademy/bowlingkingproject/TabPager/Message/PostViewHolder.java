package com.example.tacademy.bowlingkingproject.TabPager.Message;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tacademy.bowlingkingproject.R;
import com.example.tacademy.bowlingkingproject.TabPager.model.Post;

/**
 * Created by Tacademy on 2017-02-06.
 */

public class PostViewHolder extends RecyclerView.ViewHolder
{
    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }

    TextView  content;

    public PostViewHolder(View itemView) {
        super(itemView);
        content     = (TextView) itemView.findViewById(R.id.contents);
    }
    // 데이터를 개별 뷰에 설정
    public void bindToPost(Post model, View.OnClickListener listener)
    {

        content.setText(model.getContent());
    }
}
