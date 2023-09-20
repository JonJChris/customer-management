import React, { useEffect, useState } from 'react'
import { Link, NavLink, useLocation } from 'react-router-dom'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { useSelector, useDispatch } from 'react-redux';
import {actions} from './../../../store/user-store'
const NavBarCustom = () => {
  const userStore = useSelector(state => state.UserStoreSlice);
  const dispatch = useDispatch();

  const logoutHandler = () => {
    dispatch(actions.unsetUserDetail());
  }


  return (
    <div>
      <Nav className="bg-body-tertiary custom-nav-bar navbar navbar-expand-lg">
        <Container style={{paddingTop:'0px'}}>

          <Navbar.Brand href="/" style={{ paddingRight: '500px',  fontWeight:'bold', fontSize:'1rem' }}>Customer Management System</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {/* <Nav.Link href="#home">Home</Nav.Link> */}

              <NavDropdown title="Action" id="basic-nav-dropdown" className='my-dropdown'>
              
                <NavDropdown.Item as={Link} to="/search/request" >Search Request</NavDropdown.Item>
                <NavDropdown.Item as={Link} to="/search/customer">Search Customer</NavDropdown.Item>
                
                      <NavDropdown.Divider />
                      <NavDropdown.Item as={Link} to="/request/createNewCustomerRequest">
                          Create New Customer
                      </NavDropdown.Item> 
                  
                
                


              </NavDropdown>
              <NavDropdown title="Current User" id="basic-nav-dropdown" className='my-dropdown' style={{marginLeft:'150px' }}>
                <NavDropdown.ItemText className='header-title'>
                  {userStore.userDetails && userStore.userDetails.userFirstName + ' '+ userStore.userDetails.userLastName}
                  </NavDropdown.ItemText>
                  <NavDropdown.Divider />
                  <NavDropdown.Header >Roles</NavDropdown.Header>
                  
                {
                  userStore.userDetails && userStore.userDetails.userRoles && userStore.userDetails.userRoles.map(
                      roleItem => (
                        <NavDropdown.ItemText key={roleItem.roleTypeId} className='my-dropdown-medium-text' >{roleItem.roleTypeDescription}</NavDropdown.ItemText>        
                      )
                  )
                }                  
                
                <NavDropdown.Divider />
                <NavDropdown.Item as={Link} to="/request/createNewCustomerRequest" onClick={logoutHandler}>
                  Logout
                </NavDropdown.Item>
              </NavDropdown>

            </Nav>
          </Navbar.Collapse>
        </Container>
      </Nav>

    </div>
  )
}

export default NavBarCustom