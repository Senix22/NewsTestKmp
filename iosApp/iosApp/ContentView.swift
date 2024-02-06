import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
    @State private var shouldOpenAbout = false
	 var body: some View {
        NavigationStack{
            ArticlesScreen(viewModel: .init())
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            DeviceInfoView()
                        }
                    }
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
