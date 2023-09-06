import React from 'react'
import TextField from './elements/TextField'

const Login = () => {
    return (
        <div className='form-container'>

            <form className='border rounded p-5'>

                <section className='form-title'>Customer Managment System</section>
                <br /><br />
                <TextField fieldType="email" fieldId="emailAddress" fieldName="Email Address" fieldPlaceholder="Enter Email Address" />
                <br />
                <TextField fieldType="passoword" fieldId="password" fieldName="Password" fieldPlaceholder="Enter Password" />
                <br />
                <div className='form--login-button-group'><button type="submit" className="btn btn-primary">Login</button></div>
            </form>

        </div>
    )
}

export default Login
