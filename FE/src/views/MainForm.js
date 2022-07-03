import React, { useEffect } from 'react'
import { Helmet } from 'react-helmet'
import './MainForm.css'
import axios from 'axios';


class Frame1 extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      collection: [],
      policyNumber: "",
      name: "",
      surname: "",
      requestText: "",
      requestTypeId: 0,
    };

    this.updatePolicy = this.updatePolicy.bind(this);
    this.updateName = this.updateName.bind(this);
    this.updateSurname = this.updateSurname.bind(this);
    this.updateRequestText = this.updateRequestText.bind(this);
    this.updateRequest = this.updateRequest.bind(this);
    this.sendRequest = this.sendRequest.bind(this);
    this.sendNewRequest = this.sendNewRequest.bind(this);
  }

  componentDidMount() {
    let initialTypes = [];
    var targetUrl = 'http://localhost:8081/api/v1/requests/types';
    fetch(targetUrl)
      .then(response => {
        return response.json();
      }).then(data => {
        initialTypes = data.map((type) => {
          return type
        });
        console.log(initialTypes);
        this.setState({ collection: initialTypes });
      });
  }

  updatePolicy(event) {
    this.setState({ policyNumber: event.target.value });
  };
  updateName(event) {
    this.setState({ name: event.target.value });
  };
  updateSurname(event) {
    this.setState({ surname: event.target.value });
  };
  updateRequestText(event) {
    this.setState({ requestText: event.target.value });
  };
  updateRequest(event) {
    this.setState({ requestTypeId: event.target.value });
  }

  sendNewRequest() {
    const data = {
      requestTypeId: this.state.requestTypeId,
      policyNumber: this.state.policyNumber,
      name: this.state.name,
      surname: this.state.surname,
      message: this.state.requestText
    };
    axios.put('http://localhost:8081/api/v1/requests', data)
      .then(response => {
        console.log("Status: ", response.status);
        console.log("Data: ", response.data);
      }).catch(error => {
        console.error(error);
        alert("ERROR: " + error.response.data);
      });

  }
  sendRequest(event) {
    this.sendNewRequest();
  }

  render() {
    let types = this.state.collection;
    return (
      <div className="frame1-container">
        <Helmet>
          <title>exported project</title>
        </Helmet>
        <div className="frame1-frame1">
          <div className="frame1-group1">
            <div className="frame1-form">
              <span className="frame1-text">Contact us</span>
            </div>
            <div className="frame1-list">
              <form onSubmit={this.handleSubmit}>
                <label>
                  <select value={this.state.requestTypeId} onChange={this.updateRequest}>
                    {types.map(option => (
                      <option key={option.id} value={option.id}>
                        {option.label}
                      </option>
                    ))}
                  </select>
                </label>
              </form>
            </div>

            <div className="frame1-policy">
              <span className="frame1-text1">Policy Number</span>
              <input
                type="text"
                className="frame1-textinput input"
                required
                value={this.state.policyNumber}
                onChange={this.updatePolicy}
              />
            </div>
            <div className="frame1-menu">
              <span className="frame1-text2">Kind of Request</span>
              <ul className="list"></ul>
            </div>
            <div className="frame1-name">
              <span className="frame1-text3">Name</span>
              <input
                type="text"
                className="frame1-textinput1 input"
                required
                value={this.state.name}
                onChange={this.updateName}
              />
            </div>
            <div className="frame1-surname">
              <span className="frame1-text4">Surname</span>
              <input
                type="text"
                className="frame1-textinput2 input"
                required
                value={this.state.surname}
                onChange={this.updateSurname}
              />
            </div>
            <div className="frame1-request">
              <span className="frame1-text5">Your request</span>
              <textarea
                id="request"
                name="request"
                rows="4"
                cols="50"
                className="textarea1"
                maxLength="2000"
                value={this.state.requestText}
                onChange={this.updateRequestText} />
            </div>
            <button className="frame1-button button" onClick={this.sendRequest}>
              <span className="frame1-text6">SEND REQUEST</span>
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default Frame1;
