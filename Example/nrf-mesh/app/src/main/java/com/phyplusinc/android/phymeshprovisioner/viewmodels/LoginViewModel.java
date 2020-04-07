package com.phyplusinc.android.phymeshprovisioner.viewmodels;

import androidx.annotation.NonNull;

import javax.inject.Inject;

/**
 * ViewModel for {@link com.phyplusinc.android.phymeshprovisioner.login.LoginActivity}
 */
public class LoginViewModel extends BaseViewModel {

    @Inject
    LoginViewModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
