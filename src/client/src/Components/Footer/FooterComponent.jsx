import React, {Component} from 'react';
import SimpleReactFooter from "simple-react-footer";

class FooterComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    render() {

        //const credit =" EIST Project 2022 | @Team: Debugging Penguins | @Authors: Akshat Tandon, Eben Jowie Haezer, Jonas Arnold, Kilian Burger, Saiyam Jain\n" ;
        const description = "According to Wikipedia, Pingu is the main character of the show, a typically playful, curious little penguin. His name comes from the German word for penguin, Pinguin. He is stubborn and mostly well-behaved but prone to making mischief and throwing occasional tantrums.";
        const title = "AirPingu";
        const columns = [
            {
                title: "Resources",
                resources: [
                    {
                        name: "About",
                        link: "/about"
                    },
                    {
                        name: "Careers",
                        link: "/careers"
                    },
                    {
                        name: "Contact",
                        link: "/contact"
                    },
                    {
                        name: "Admin",
                        link: "/admin"
                    }
                ]
            },
            {
                title: "Legal",
                resources: [
                    {
                        name: "Privacy",
                        link: "/privacy"
                    },
                    {
                        name: "Terms",
                        link: "/terms"
                    }
                ]
            },
            {
                title: "Visit",
                resources: [
                    {
                        name: "Locations",
                        link: "/locations"
                    },
                    {
                        name: "Culture",
                        link: "/culture"
                    }
                ]
            }
        ];
        return <SimpleReactFooter
            description={description}
            title={title}
            columns={columns}
            linkedin="linkedin.comn"
            facebook="facebook.com"
            twitter="twitter.com"
            instagram="instagram.com"
            youtube="https://www.youtube.com/channel/youtube.com"
            pinterest="fluffy_cats_collections"
            copyright="airpingu"
            iconColor="black"
            backgroundColor="grey"
            fontColor="black"
            copyrightColor="darkgrey"
        />;
        /*
        return (
            <footer className="footer">
                EIST Project 2022 | @Team: Debugging Penguins | @Authors: Akshat Tandon, Eben Jowie Haezer, Jonas Arnold, Kilian Burger, Saiyam Jain
            </footer>
        );

         */
    }
}

export default FooterComponent;
