import Ui.Menu
import Repository.Repository

class Main {
    static void main(String[] args) {
        def repo = new Repository()
        repo.setup()
        Menu.startMenu(repo)
    }
}
