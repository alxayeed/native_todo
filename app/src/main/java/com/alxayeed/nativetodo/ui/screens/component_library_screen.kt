import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alxayeed.nativetodo.ui.components.CustomButton
import com.alxayeed.nativetodo.ui.components.CustomTextField
import com.alxayeed.nativetodo.ui.components.EmptyContent
import com.alxayeed.nativetodo.ui.components.ErrorContent
import com.alxayeed.nativetodo.ui.components.FAB
import com.alxayeed.nativetodo.ui.components.LoadingIndicator

@Composable
fun ComponentLibraryScreen() {
    // Scroll state for vertical scrolling
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()     // add safe area padding for status/navigation bars
            .verticalScroll(scrollState)   // make content scrollable
            .padding(16.dp)          // inner padding
    ) {
        Text("Custom Button:")
        CustomButton(text = "Click Me", onClick = {})

        Spacer(modifier = Modifier.height(16.dp))

        Text("Custom TextField:")
        var text by remember { mutableStateOf("") }
        CustomTextField(value = text, onValueChange = { text = it }, label = "Enter Text")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Empty Content:")
        EmptyContent(message = "No items found")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Loading Indicator:")
        LoadingIndicator()

        Spacer(modifier = Modifier.height(16.dp))

        Text("FAB:")
        FAB(onClick = {})

        Spacer(modifier = Modifier.height(16.dp))

//        Text("Alert Dialog:")
//        AlertDialogComponent(
//            title = "Warning",
//            message = "Are you sure?",
//            onConfirm = {},
//            onDismiss = {}
//        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Error Content:")
        ErrorContent(message = "Something went wrong!")
    }
}
