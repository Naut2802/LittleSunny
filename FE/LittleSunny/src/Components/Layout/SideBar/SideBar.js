import * as React from 'react';
import { Link } from 'react-router-dom';
import logo from '~/LittleSunny.png';
import './SideBar.module.scss';

function SideBar() {
    return (
        <div className="sideBar">
            <div className="col-auto">
                <div className="bg-white border rounded-3 min-vh-100 d-flex justify-content-between flex-column">
                    <div>
                        <Link
                            to="/home"
                            className="text-decoration-none text-black
                            d-flex justify-content-center"
                        >
                            <img
                                src={logo}
                                alt=""
                                className="img-fluid justify-content-center"
                                style={{ width: 100 }}
                            />
                        </Link>
                        <hr className="text-secondary d-none d-sm-block" />
                        <ul className="nav nav-pills flex-column">
                            <li className="nav-item fs-4 my-1 py-2 py-sm-0">
                                <Link to="addS" className="nav-link  text-black">
                                    <i className="bi bi-person-add"></i>
                                    <span className="ms-3 d-none d-sm-inline">Thêm Học Viên</span>
                                </Link>
                            </li>
                            <li className="nav-item fs-4 my-1 py-2 py-sm-0">
                                <Link to="student" className="nav-link  text-black">
                                    <i className="bi bi-card-list"></i>
                                    <span className="ms-3 d-none d-sm-inline">Danh Sách Học Viên</span>
                                </Link>
                            </li>
                            <li className="nav-item fs-4 my-1 py-2 py-sm-0">
                                <Link to="classes" className="nav-link  text-black">
                                    <i className="bi bi-list"></i>
                                    <span className="ms-3 d-none d-sm-inline">Danh Sách Lớp</span>
                                </Link>
                            </li>
                            <li className="nav-item fs-4 my-1 my- py-2 py-sm-0">
                                <Link to="course" className="nav-link  text-black">
                                    <i className="bi bi-card-checklist"></i>
                                    <span className="ms-3 d-none d-sm-inline">Danh Sách Khóa</span>
                                </Link>
                            </li>
                            <li className="nav-item fs-4 my-1 py-2 py-sm-0">
                                <Link to="thongke" className="nav-link  text-black">
                                    <i className="bi bi-bar-chart"></i>
                                    <span className="ms-3 d-none d-sm-inline">Thống Kê</span>
                                </Link>
                            </li>
                        </ul>
                    </div>
                    <div className="btn-group w-100 min-vh-10 mb-3">
                        <button
                            type="button"
                            className="btn btn-secondary dropdown-toggle"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                        >
                            <i className="bi bi-person-circle"></i>
                            <span className="ms-2 d-none d-sm-inline my-1 py-2 py-sm-0">ADMIN nè</span>
                        </button>
                        <ul className="dropdown-menu dropdown-menu-end">
                            <li>
                                <button className="dropdown-item" type="button">
                                    <i className="bi bi-door-open"></i>
                                    <span className="ms-2 d-none d-sm-inline">Đăng Xuất</span>
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default SideBar;