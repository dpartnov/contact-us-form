import React from 'react'
import ReactDOM from 'react-dom'
import { BrowserRouter as Router, Route } from 'react-router-dom'

import './style.css'
import MainForm from './views/MainForm'

const App = () => {
  return (
    <Router>
      <div>
        <Route exact component={MainForm} path="/" />
      </div>
    </Router>
  )
}

ReactDOM.render(<App />, document.getElementById('app'))
