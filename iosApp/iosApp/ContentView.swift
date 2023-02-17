import SwiftUI
import shared

struct ContentView: View {
    private var platformModel : Platform = Platform()
    let greet = Platform().platform

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
