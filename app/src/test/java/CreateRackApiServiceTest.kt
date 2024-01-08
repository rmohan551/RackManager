import com.example.rackmanager.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

class CreateRackApiServiceTest {

    private val apiService: ApiService = mock(ApiService::class.java)

    @Test
    fun testCreateRack() = runBlocking {

    }
}
