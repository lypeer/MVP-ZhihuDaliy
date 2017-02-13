package ${packageName};

import android.support.annotation.NonNull;

import ${rootName}.framework.BasePresenter;
import ${rootName}.framework.BasePresenterApi;

public class ${name}Presenter extends BasePresenter<${name}Contract.View , TargetRepository> implements BasePresenterApi {
    
    public ${name}Presenter(@NonNull TargetRepository repository, @NonNull ${name}Contract.View view) {
        super(repository, view);
    }

    @Override
    public void start() {
        
    }
}
