package com.phyplusinc.android.phymeshprovisioner.viewmodels;

import androidx.annotation.NonNull;

import javax.inject.Inject;

/**
 * ViewModel for {@link com.phyplusinc.android.phymeshprovisioner.advancesetting.AdvanceSettingActivity}
 */
public class AdvanceSettingModel extends BaseViewModel {

    @Inject
    AdvanceSettingModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
