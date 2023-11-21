import SwiftUI
import shared

class NotesListObservableObject: ObservableObject {
    var viewModel: NotesListViewModel
    
    init(viewModel: NotesListViewModel) {
        self.viewModel = viewModel
    }
}

extension NotesListViewModel {
    func asObservableObject() -> NotesListObservableObject {
        return NotesListObservableObject(viewModel: self)
    }
}

struct ContentView: View {
    @ObservedObject var viewModelComponent = ViewModelComponent().getNotesListViewModel().asObservableObject()
    
	var body: some View {
//        Text(viewModelComponent.viewModel.getString())
        Text(" XD ")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
