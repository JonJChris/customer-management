import React from 'react'
import { Link, NavLink, useLocation } from 'react-router-dom'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
const NavBarCustom = () => {
    
  return (
    <div>
      <Nav  class="bg-body-tertiary custom-nav-bar navbar navbar-expand-lg">
        <Container>
          <Navbar.Brand href="/">Customer Management System</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {/* <Nav.Link href="#home">Home</Nav.Link> */}
              
              <NavDropdown title="Action" id="basic-nav-dropdown" className='my-dropdown'>
                <NavDropdown.Item href="/search/request" >Search Request</NavDropdown.Item>
                <NavDropdown.Item href="/search/customer">Search Customer</NavDropdown.Item>
                
                <NavDropdown.Divider />
                <NavDropdown.Item href="/request/createNewCustomerRequest">
                  Create New Customer
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