import SwiftUI
import shared

class SampleObservableObject: ObservableObject {
    var viewModel: SampleViewModel
    
    init(viewModel: SampleViewModel) {
        self.viewModel = viewModel
    }
}

extension SampleViewModel {
    func asObservableObject() -> SampleObservableObject {
        return SampleObservableObject(viewModel: self)
    }
}

struct ContentView: View {
    @ObservedObject var viewModel = ViewModels().getSampleViewModel().asObservableObject()
    
	var body: some View {
        Text(viewModel.viewModel.getString())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
