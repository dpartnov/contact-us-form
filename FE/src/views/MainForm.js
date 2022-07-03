import React from 'react'
import { Helmet } from 'react-helmet'
import './MainForm.css'


class Frame1 extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      policyNumber: "",
      name: "",
      surname: "",
      requestText: "",
      requestTypeId: "",
    };
    
    this.updatePolicy = this.updatePolicy.bind(this);
    this.updateName = this.updateName.bind(this);
    this.updateSurname = this.updateSurname.bind(this);
    this.updateRequestText = this.updateRequestText.bind(this);
    this.updateRequest = this.updateRequest.bind(this);
    this.sendRequest = this.sendRequest.bind(this);
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
  sendRequest(event) {
    console.log("Send request with params: \n"
      + "policyNumber: " + this.state.policyNumber + "\n"
      + "name: " + this.state.name + "\n"
      + "surname: " + this.state.surname + "\n"
      + "requestText: " + this.state.requestText + "\n"
      + "requestTypeId: " + this.state.requestTypeId);
  }

  render() {

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
                    <option value="value 1">Value 1</option>
                    <option value="value 2">Value 2</option>
                    <option value="value 3">Value 3</option>
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
