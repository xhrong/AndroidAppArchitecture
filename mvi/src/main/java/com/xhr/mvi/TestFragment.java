package com.xhr.mvi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.xhr.mvi.bean.CounterBean;
import com.xhr.mvi.controller.CounterController;
import com.xhr.mvi.controller.CounterController1;
import com.xhr.mvi.intent.CounterIntent;
import com.xhr.mvi.model.CounterViewState;
import com.xhr.mvi.view.CounterView;

public class TestFragment extends Fragment implements CounterView{

    private Activity mActivity;
    private TextView textView;

    private CounterController1 counterController;

    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        counterController = new CounterController1(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        textView = root.findViewById(R.id.text);

        return root;
    }


    @Override
    public CounterIntent intentAdd() {
       return null;
    }

    @Override
    public CounterIntent intentSub() {
        return null;
    }

    @Override
    public void render(CounterViewState viewState) {
        textView.setText(viewState.getCountStr());
    }

    @Override
    public void observer(MutableLiveData<CounterViewState> counterViewStateMutableLiveData) {
        counterViewStateMutableLiveData.observe(this, new Observer<CounterViewState>() {
            @Override
            public void onChanged(CounterViewState viewState) {
                render(viewState);
            }
        });
    }

}
