
import {ref,computed} from 'vue'
import Home from './home.html'
import About from './about.html'
import NotFound from './notFound.html'

const routes = {
	'/':Home,
	'/about':About,
}

const currentPath = ref(window.localtion.hash)

window.addEveListener('hashchange',()=>{
	currentPath.value = window.value.hash
})

const currentView = computed(()=>{
	return routes[currentPath]
})


