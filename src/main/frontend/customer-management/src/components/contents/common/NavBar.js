import React from 'react'

const NavBar = () => {
    return (
        <div>


            <div>
                <nav className='row nav-bar'>
                    <ul>
                        <li className='col-8' ><a href="#">CMS</a></li>
                        <li className='col-2'><a href="#">Plugins</a></li>
                        <li className='col-2'><a href="#">Tutorials</a>
                        <ul className='dropdown-content'>
                        <li><a href="#">Themes</a></li>
                        <li><a href="#">Plugins</a></li>
                        <li><a href="#">Tutorials</a></li>
                    </ul>
                        </li>
                    </ul>
                </nav>
                {/* <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">WordPress</a>
            
            <ul>
                <li><a href="#">Themes</a></li>
                <li><a href="#">Plugins</a></li>
                <li><a href="#">Tutorials</a></li>
            </ul>        
            </li>
            <li><a href="#">Web Design</a>
            
            <ul>
                <li><a href="#">Resources</a></li>
                <li><a href="#">Links</a></li>
                <li><a href="#">Tutorials</a>
            	
                <ul>
                    <li><a href="#">HTML/CSS</a></li>
                    <li><a href="#">jQuery</a></li>
                    <li><a href="#">Other</a>
                
                        <ul>
                            <li><a href="#">Stuff</a></li>
                            <li><a href="#">Things</a></li>
                            <li><a href="#">Other Stuff</a></li>
                        </ul>
                    </li>
                </ul>
                </li>
            </ul>
            </li>
            <li><a href="#">Graphic Design</a></li>
            <li><a href="#">Inspiration</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="#">About</a></li>
        </ul>
    </nav> */}
            </div>

        </div>
    )
}

export default NavBar