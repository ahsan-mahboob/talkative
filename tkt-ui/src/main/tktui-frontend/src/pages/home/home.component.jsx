import React, { useState, useEffect, useRef } from "react";
import axios from 'axios';

import List from "../../components/list/list.component";
import Send from "../../components/list/send.component";


class Home extends React.Component {
    state = {
        messages: []
    }
    //const [msgData, setMsgData] = useState({messages: []});
    //const webSocket = useRef(null);
    // instance of websocket connection as a class property
    //ws = new WebSocket('ws://dcd01988:8080/tkt-listener-1.0.0.0/app')
    
    ws = new WebSocket('ws://localhost:9002/tkt-listener/app')

    componentDidMount() {
        this.ws.onopen = () => {
            // on connecting, do nothing but log it to the console
            console.log('connected')
        }

        this.ws.onmessage = evt => {
        // listen to data sent from the websocket server
            const message = JSON.parse(evt.data)
            this.setState({ messages: [...this.state.messages, message] })
            console.log(message)
        }

        this.ws.onclose = evt => {
            console.log('disconnected', evt)
            // automatically try to reconnect on connection loss
        }

         axios.get(`http://localhost:9009/tkt-index/messages`)
          .then(result => {
             this.setState(result.data._embedded)
          })
          .catch(console.error)
    }

    render(){
        return (

        <div>
            <Send/>
         { 
            this.state.messages.length > 0 ? (<List data={this.state}/>) : "No Data" 
         } 
         </div>
         )
    }

}

export default Home;