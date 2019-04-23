package br.com.rectius.blocodenotas.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rectius.blocodenotas.model.Nota
import br.com.rectius.blocodenotas.repository.NotaRepository

class MainViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val notas : MutableLiveData<List<Nota>> = MutableLiveData()
    val mensagemErro : MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    fun buscarTodos () {
        isLoading.value = true
        notaRepository.buscarTodos(
            onComplete = {
                isLoading.value = false
                notas.value = it

            },
            onError = {
                isLoading.value = false
                mensagemErro.value = it?.message
            }
        )
    }

}