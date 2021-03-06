package com.example.pagingsample.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.example.pagingsample.model.character.CharacterWithDetails
import com.example.pagingsample.model.episode.EpisodeWithDetails
import com.example.pagingsample.model.location.LocationWithDetails
import com.example.pagingsample.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

abstract class DetailsViewModel<D : Any> (
    private val detailsRepository: DetailsRepository<D>
) : ViewModel(), ContainerHost<DetailsState, NavigationSideEffect> {

    override val container: Container<DetailsState, NavigationSideEffect> =
        container(DetailsState.Loading)

    @CallSuper
    fun postAction(action: DetailsUiAction) = intent {
        when(action) {
            is DetailsUiAction.Update -> {
                val item = getItemById(action.id)
                reduce { DetailsState.Data(item) }
            }
            is DetailsUiAction.Navigate -> {
                postSideEffect(NavigationSideEffect(action.id))
            }
        }
    }

    private suspend fun getItemById(id: Long) : D {
        return detailsRepository.getFlowByItemId(id)
    }
}



sealed class DetailsUiAction {
    data class Update(val id: Long) : DetailsUiAction()
    data class Navigate(val id: Long) : DetailsUiAction()
}


sealed class DetailsState {
    object Loading : DetailsState()
    class Data<D>(val item: D) : DetailsState()
    object Error : DetailsState()
}
//TODO INVESTIGATE HILT DI AND DELETE THIS CLASSES

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    detailsRepository: DetailsRepository<CharacterWithDetails>
) : DetailsViewModel<CharacterWithDetails>(detailsRepository)

@HiltViewModel
class LocationDetailsViewModel @Inject constructor(
    detailsRepository: DetailsRepository<LocationWithDetails>
) : DetailsViewModel<LocationWithDetails>(detailsRepository)

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    detailsRepository: DetailsRepository<EpisodeWithDetails>
) : DetailsViewModel<EpisodeWithDetails>(detailsRepository)



