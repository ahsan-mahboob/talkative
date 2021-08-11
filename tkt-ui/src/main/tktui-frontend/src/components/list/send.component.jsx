import React, { useState } from "react"
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button'


const Send = () => {
    const [message, setMessage] = useState('')

    const btnCLicked = (msg) => {
        if(!msg) {
            alert('Enter a message')
            return
        }
        //const message = { msg: msg };
        fetch('http://localhost:9009/tkt-sender/message/send', {
                method: 'POST',
                body: new URLSearchParams({
                    msg
                })
            });

    }

    return (
        <div style={{textAlign: 'center', marginBottom: '10px'}}>
            <TextField id="outlined-basic" label="Type a Msg" variant="outlined" onChange={(e) => setMessage(e.target.value)}/>
            <Button variant="contained" color="primary" onClick={() => btnCLicked(message)}>
                Send
            </Button>
        </div>
    )
}

export default Send