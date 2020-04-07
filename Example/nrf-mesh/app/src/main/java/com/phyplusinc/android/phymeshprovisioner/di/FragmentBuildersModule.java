/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.phyplusinc.android.phymeshprovisioner.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.phyplusinc.android.phymeshprovisioner.GroupsFragment;
import com.phyplusinc.android.phymeshprovisioner.NetworkFragment;
import com.phyplusinc.android.phymeshprovisioner.ProxyFilterFragment;
import com.phyplusinc.android.phymeshprovisioner.SettingsFragment;
import com.phyplusinc.android.phymeshprovisioner.advancesetting.BatteryFragment;
import com.phyplusinc.android.phymeshprovisioner.advancesetting.LoadFragment;
import com.phyplusinc.android.phymeshprovisioner.advancesetting.OtherFragment;

@Module
abstract class FragmentBuildersModule {
	@ContributesAndroidInjector
	abstract NetworkFragment contributeNetworkFragment();
	@ContributesAndroidInjector
	abstract GroupsFragment contributeGroupFragment();
	@ContributesAndroidInjector
	abstract ProxyFilterFragment contributeProxyFilterFragment();
	@ContributesAndroidInjector
	abstract SettingsFragment contributeSettingsFragment();
	@ContributesAndroidInjector
	abstract LoadFragment contributeLoadFragment();
	@ContributesAndroidInjector
	abstract BatteryFragment contributeBatteryFragment();
	@ContributesAndroidInjector
	abstract OtherFragment contributeOtherFragment();
}