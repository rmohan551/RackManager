import com.example.rackmanager.ApiService
import com.example.rackmanager.RackEntity
import kotlinx.coroutines.runBlocking
import okhttp3.Response
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

    class GetAllRacksApiServiceTest {

        private val apiService: ApiService = mock(ApiService::class.java)

        @Test
        fun testGetAllRacks() = runBlocking {
            // Mock response from ApiService
            val mockRacksList = listOf(RackEntity("Rack1"), RackEntity("Rack2"))

            // Create a Response manually
            val response = Response.success(mockRacksList)

            `when`(apiService.getAllRacks()).thenReturn(response)

            // Call the method you want to test
            val result = apiService.getAllRacks()

            // Verify the result or perform assertions
            if (result.isSuccessful) {
                val racksList: List<RackEntity>? = result.body()
                assert(racksList == mockRacksList)
            } else {
                println("Unsuccessful response. HTTP Code: ${result.code}")

            }
        }
            }
