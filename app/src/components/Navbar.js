import React, { useState } from 'react';
import Diamond_Data_Logo_White from "../assets/Diamond_Data_Logo_White.PNG";
import { Link } from 'react-router-dom';
import ReorderIcon from '@mui/icons-material/Reorder';
import SettingsIcon from '@mui/icons-material/Settings'; // Import the Settings icon
import '../styles/Navbar.scss';

function Navbar() {
    const [openLinks, setOpenLinks] = useState(false);

    const toggleNavbar = () => {
        setOpenLinks(!openLinks);
    }

    return (
        <div className="navbar">
            <div className="leftSide" id={openLinks ? "open" : "close"}>
                <img src={Diamond_Data_Logo_White} />
                <div className="hiddenLinks">
                    <Link to="/Home"> Home </Link>
                    <Link to="/PlayerManagement"> Player Management </Link>
                    <Link to="/TeamStats"> Team Stats </Link>
                    <Link to="/PlayerStats"> Player Stats </Link>
                    <Link to="/Roster"> Roster </Link>
                    <Link to="/Insights"> Insights </Link>
                    <Link to="/BulkEntry"> Bulk Entry </Link>
                    <Link to="/Settings">
                        <SettingsIcon style={{ fontSize: 32, color: '#FFF' }} />
                    </Link>
                </div>
            </div>
            <div className="rightSide">
                <Link to="/Home"> Home </Link>
                <Link to="/PlayerManagement"> Player Management </Link>
                <Link to="/TeamStats"> Team Stats </Link>
                <Link to="/PlayerStats"> Player Stats </Link>
                <Link to="/Roster"> Roster </Link>
                <Link to="/Insights"> Insights </Link>
                <Link to="/BulkEntry"> Bulk Entry </Link>
                <Link to="/Settings">
                    <SettingsIcon style={{ fontSize: 32, color: '#FFF' }} />
                </Link>
                <button onClick={toggleNavbar}>
                    <ReorderIcon />
                </button>
            </div>
        </div>
    )
}

export default Navbar;
