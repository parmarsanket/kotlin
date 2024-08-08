package com.example.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel(private val dao :ContectDao):ViewModel()
{
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _state = MutableStateFlow(ContactState())

      fun onEvent(event : ContactEvent)
      {
          when(event)
          {
              is ContactEvent.DeleteContact ->
              {
                  viewModelScope.launch {
                      dao.deleteContact(event.contact)
                  }
              }
              ContactEvent.HideDialog -> {
                 _state.update {
                      it.copy(dialogVisible = false)

                 }

              }
              ContactEvent.SaveContact -> TODO()
              ContactEvent.ShowDialog -> TODO()
              is ContactEvent.SortContact -> TODO()
              is ContactEvent.setFristname -> TODO()
              is ContactEvent.setLastname -> TODO()
              is ContactEvent.setphoneNumber -> TODO()
          }








      }
}