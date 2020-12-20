package com.xhr.mvp_clean.usecase;

import androidx.annotation.NonNull;

import com.xhr.mvp_clean.base.UseCase;
import com.xhr.mvp_clean.model.CounterModel;
import com.xhr.mvp_clean.repo.CounterRepository;

public class CountTask extends UseCase<CountTask.RequestValues, CountTask.ResponseValue> {

    private final CounterRepository counterRepository;

    public CountTask(@NonNull CounterRepository counterRepository) {
        this.counterRepository = counterRepository;

    }


    @Override
    protected void executeUseCase(RequestValues requestValues) {
        CounterModel counterModel = counterRepository.operateCounter(requestValues.getStep());
        getUseCaseCallback().onSuccess(new ResponseValue(counterModel));
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private int step;

        public RequestValues(int s) {
            this.step = s;
        }

        public int getStep() {
            return step;
        }

    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private CounterModel counterModel;

        public ResponseValue(CounterModel counterModel) {
            this.counterModel = counterModel;
        }


        public CounterModel getCounterModel() {
            return counterModel;
        }

    }
}
