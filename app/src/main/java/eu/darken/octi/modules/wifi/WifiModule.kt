package eu.darken.octi.modules.wifi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import eu.darken.octi.common.BuildConfigWrap
import eu.darken.octi.modules.ModuleId
import eu.darken.octi.modules.ModuleRepo
import eu.darken.octi.modules.ModuleSync
import eu.darken.octi.modules.wifi.core.WifiRepo
import eu.darken.octi.modules.wifi.core.WifiSync

@InstallIn(SingletonComponent::class)
@Module
class WifiModule {

    @Provides
    @IntoSet
    fun sync(sync: WifiSync): ModuleSync<out Any> = sync

    @Provides
    @IntoSet
    fun repo(repo: WifiRepo): ModuleRepo<out Any> = repo

    @Provides
    @IntoSet
    fun moduleId(): ModuleId = MODULE_ID

    companion object {
        val MODULE_ID = ModuleId("${BuildConfigWrap.APPLICATION_ID}.module.core.wifi")
    }
}