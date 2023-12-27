/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rackmanager.DBHelper
import com.example.rackmanager.RackEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RackViewModel(private val rackRepository: RackRepository) : ViewModel() {

    val allRacks: LiveData<List<RackEntity>> = rackRepository.getAllRacks()

    suspend fun insert(rack: RackEntity) {
        withContext(Dispatchers.IO) {
            rackRepository.insert(rack)
        }
    }
}

class RackRepository(private val dbHelper: DBHelper) {

    private val rackDao = dbHelper.getRackDao()

    fun getAllRacks(): LiveData<List<RackEntity>> {
        return rackDao.getAllRacks()
    }

    fun insert(rack: RackEntity) {
        dbHelper.runInTransaction {
            rackDao.insert(rack)
        }
    }
}
*/

