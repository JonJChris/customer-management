import React, { useState } from 'react'
import TextField from './elements/TextField'
import { postRequestAndThenCallBack } from './utility/api-util'
import PasswordField from './elements/PasswordField'
import { useDispatch } from 'react-redux'
import { actions } from './../store/user-store'
import { useNavigate } from 'react-router-dom'
const Login = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const loginResponseHandler = (response) => {
        if (response.authorisationResponseType === 'LOGIN_FAILED') {
            setMsg(`Login Error: ${response.authorisationResponseMessage}`);
        } else if (response.authorisationResponseType === 'LOGIN_SUCCESS') {
            setMsg();
            dispatch(actions.setUserDetail(response));
            navigate('/');

        }
  
    }
    const submitHandler = (evt) => {
        evt.preventDefault();
        const requestBody = {
            userName: userCredential.username,
            password: userCredential.password,
        }
        postRequestAndThenCallBack("http://localhost:8080/api/auth/login", requestBody, loginResponseHandler);

    }

    const changeHandler = (evt) => {
    
        setUserCredential((prev) => {
            return {
                ...prev,
                [evt.target.name]: evt.target.value
            }
        });

    }
    const [msg, setMsg] = useState("");
    const [userCredential, setUserCredential] = useState({ username: '', password: '' })
    return (
        <div className='form-container'>

            <form className='border rounded p-3' onSubmit={submitHandler}>

                <section className='form-title'>Customer Managment System</section>
                <br /><br />
                <TextField fieldType="username" fieldId="username" fieldName="User Name" fieldPlaceholder="Enter User Name"
                    isMandatory={true} isEditable={true} isVisible={true} fieldOnChange={changeHandler} fieldValue={userCredential.username} />
                <br />
                <PasswordField fieldType="passoword" fieldId="password" fieldName="Password" fieldPlaceholder="Enter Password"
                    isMandatory={true} isEditable={true} isVisible={true} fieldOnChange={changeHandler} fieldValue={userCredential.password} />
                <br />
                <label className='text-danger p-2'><strong>{msg}</strong></label>
                <br /><br />
                <div className='form--login-button-group'><button type="submit" className="btn btn-primary"
                    disabled={userCredential.username === '' || userCredential.password === ''}>Login</button></div>
            </form>
            <br/ >
            <div className='border border-rounded p-3'>
                <table className="table">
                    <thead>
                        <tr>
                            <th>USER NAME</th><th>PASSWORD</th><th>ROLES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>maggieparker</th><td>password</td><td>CREATE CUSTOMER, FRONT OFFICE</td>
                        </tr>
                        <tr>
                            <th>brianflowers</th><td>password</td><td>MAINTAIN CUSTOMER</td>
                        </tr>
                        <tr>
                            <th>chasedawson</th><td>password</td><td>CREATE_CUSTOMER, DOCUMENT_OWNER</td>
                        </tr>
                        <tr>
                            <th>robinjackson</th><td>password</td><td>FRONT OFFICE, DOCUMENT_OWNER</td>
                        </tr>
                        <tr>
                            <th>christinefloyd</th><td>password</td><td>FINAL APPROVER</td>
                        </tr>
                        <tr>
                            <th>samueloconnor</th><td>password</td><td>MAINTAIN CUSTOMER, FINAL APPROVER</td>
                        </tr>
                    </tbody>
                </table>

            </div>

        </div>
    )
}

export default Login
