<%-- 
    Document   : FAQpage
    Created on : Feb 3, 2022, 4:05:28 PM
    Author     : 845593
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Event Page for Alberta Bike Swap</title>
    <link rel="stylesheet" href="faq.css">

    <script>
        function toggleFAQCard(cardNumber) {
            var x = document.getElementById(cardNumber);
            if (x.style.display === "none" || x.style.display === "") {
                x.style.display = 'block';
            }
            else {
                x.style.display = 'none';
            }
        }
    </script>
</head>

<body>
    <Navbar> Shared Navbar component among all pages goes here </Navbar>
    <div id="contentWrapper">
        <h1 id="announcementH1">What do you want to do today?</h1>
        <div id="faqWrapper">
            <h2 id="faqTitle"> I want to. . .</h2>
            <input type="button" value="Borrow bike racks" class="faqQuestion" onclick='toggleFAQCard("Card1")'>
            <div class="faqAnswerCard" id="Card1">
                <pre>
            *** NOTES FOR 2018 ***

        Yup, all caps, bold and italics – this information is that important. Read ALL of this page. Well, I
        broke my back (Laura) so we’re going away and that means that the racks are going away too. We asked
        and asked people to take over, but only a couple of people took us up and that’s not enough to
        continue running the swaps or giving out the racks. My broken vertebrae prevent me from lifting
        racks, we need someone to take this part of the swaps over. Is that you?

        Since we donate half the profit from the bike swaps back to the community, we built bike racks from
        the profits in 2012 to keep events green throughout the province.

        What you need to know:

        Each bike rack holds ~10-12 bikes. We ask that you determine the number of bikes racks that you need
        – # of bikes you expect, divided by 10 (the number of bikes per rack) equals the number of racks
        required.

        We have an industrial design patent and designed the bike racks for our swaps. The bike racks are
        easily broken down for easier storage/transportation. Since they are easily broken down, we’ve had
        sets stolen. You are responsible for ensuring that the bike racks are never left in an open space or
        in an unlocked area.

        The bike racks can be transported in a pickup truck, and some large vans. The longest section is
        12’, and the side pieces can be placed in the bed of the truck. Make sure to bring your work gloves,
        tie downs and red flag.

        What we expect:

        We ask that you display our “Racks supplied by” banner; give us a mention in your social media
        programme for the event; and it would be deluxe to have our logo displayed in your posters and
        website.

        What we need to know:

        How many racks you need.

        The Date of your event.

        Use our contact page to request the bike racks, and well let you know if they’re available.
                </pre>
            </div>
            <input type="button" value="Know More - FAQ" class="faqQuestion" onclick='toggleFAQCard("Card2")'>
            <div class="faqAnswerCard" id="Card2">
                <p>
                    Q: Can I swap my bike?
                </p>
                <p>
                    A: No, this is a bike buy, sell and donate event. If you’re selling a bike, we’ll sell it for you
                    and there will be bikes there for you to buy.
                </p>
                <p>
                    Q: Why is your bike swap safer than online purchase?
                </p>
                <p>
                    A: We tech check the bikes and record the serial numbers. Do you know what you’re buying online or
                    who
                    you’re buying the bike from? The police and RCMP have seized bikes from pawn shops and online sales
                    based on our paperwork.
                </p>
                <p>
                    Q: Why is there a fee to sell my bike?
                </p>
                <p>
                    A: It costs us ~$32.00 out of pocket per bike before it gets into the swap; marketing, truck
                    rentals,
                    venues, bank costs, food (we have ~210 volunteers), insurance, postage, debit fees, printing,
                    security,
                    supplies, and more. We put in anywhere between $11K to $36K/year every year out of our life savings
                    to
                    fund the swaps.
                </p>
                <p>
                    Q: Do I have to be there to sell my bike?
                </p>

                <p>
                    A: No, we’ll sell your bike for you and mail you a cheque or e-transfer. It’s not just the
                    convenience
                    of the swap, you’re helping us give money back to the community by selling your bike at the swap.
                    But
                    don’t leave town in case your bike doesn’t sell and you have to come pick it up!
                </p>
                <p>
                    Q: How much will you give me for my bike?
                </p>

                <p>
                    A: Sorry, we don’t buy the bikes, but we can help you set a price for the swap.

                </p>
                <p>
                    Q: How do I go about selling a bike?

                </p>

                <p>
                    A: Bring your clean, ready to ride bike to the swap during the times indicated as BIKE DROP-OFF in
                    the
                    city at the location; it helps to have a selling price in mind. We will tech-check it and record its
                    serial number. You will sign an agreement to sell, which tells us where to send the cheque, and what
                    to
                    do with your bike in the slim chance that it doesn’t sell. You pay us a rack fee to get the bike(s)
                    in
                    the sale (AMA members get $5.00 off) to put the bike into the swap. You go away, and we send you the
                    cheque or e-transfer, less 13%.
                </p>

                <p>
                    Q: What happens if my bike doesn’t sell?

                </p>

                <p>

                    A: We have a 92% sale rate, it will likely sell, but you have to set the right price. As part of
                    registering your bike for the sale, you leave us a cell or phone number so that we can call you if
                    your
                    bike doesn’t sell. The agreement to sell form also gives the option to donate it to a local
                    non-profit.
                    We only have the venue for the day, and after a reasonable number of attempts to contact you, we
                    take
                    the bike home and it’ll be up to you to pick it up.
                </p>

                <p>
                    Q: Can I bring my kid’s bikes to sell?
                </p>

                <p>
                    A: We have children’s bikes at every swap. The only children’s bikes that we accept are better
                    quality,
                    not from box stores – we do this is to protect your child. If you want to donate children’s bikes,
                    we
                    accept outgrown bikes at ever swap, and we’ll give them to a child in need in your city.
                </p>

                <p>
                    Q: How do I get the best price for my bike?
                </p>

                <p>
                    A: Clean, cared for bikes always sell better. Write-up the upgrades, last service, new parts, etc.,
                    make
                    sure the buyers can tell the value is there.
                </p>

                <p>
                    Q: I’m out of town on Saturday, can I drop my bike off on Friday?
                </p>

                <p>
                    A: We have the venue for the day and just don’t have the resources to handle early drop-offs or take
                    bikes ahead of time.

                </p>

                <p>
                    Q: What will the prices of the bikes be?

                </p>

                <p>
                    A: Bikes range from $50 – $4000. Sellers set the price, but we encourage them to price it to sell.
                </p>

                <p>
                    Q: What is a Bicycle Shaped Object?
                </p>

                <p>
                    A: I didn’t come up with this term. It refers to box store items that look like a bike, smell like a
                    bike, but don’t pedal, shift, stop, or otherwise work the way a real bike should. A bike should make
                    you
                    want to ride it, not leave it in the alley.
                </p>
            </div>
            <input type="button" value="Donate bike(s) - THANK YOU!" class="faqQuestion"
                onclick='toggleFAQCard("Card3")'>
            <div class="faqAnswerCard" id="Card3">
                <pre>
                    Thank you.

                    We have a need in our back yard. Your bike will stay in the city or its surrounding area to help 
                    those in need. The $2.00 entrance fee we collect goes to the group fixing these donated bikes.  
                    We also have a bin for collection of parts to stock the shelves for great local non-profits that 
                    re-build bikes within your community. 
                    
                    We’re not just local, we help international causes too.  Many of the bikes at the Calgary Swap 
                    are from Bicycles for Humanity; the sale of these bikes will fund the container costs for bikes 
                    sent abroad.  We volunteer and appreciate this great group too.
                </pre>
            </div>
            <input type="button" value="Buy a bike" class="faqQuestion" onclick='toggleFAQCard("Card4")'>
            <div class="faqAnswerCard" id="Card4">
                <pre>
                    There is a $2.00 admission for adults, while kids 12 and under are free.  This money is 
                    donated to a local non-profit bike group to fix the donated bikes, we don’t keep anything.  
                    All bikes on the floor have undergone a basic tech check to make sure you don’t end up 
                    with an unsafe ride, but it is still up to you to get a full technical checkup with a 
                    participating bike shop. Please contact us if something is drastically wrong.

                    There is usually a rack of AS-IS bikes that didn’t pass the inspection, but would be a good 
                    ride for the person ready to put a bit of TLC into a new ride. This money is donated to a local 
                    non-profit bike group.
                    
                    The line-ups can be long.  The line-up to buy starts when we’re setting up racks at 0600 in the 
                    morning in Calgary and Edmonton.  If you want first dibs on a bike, please consider volunteering 
                    rather than lining up.  Lining up from 0730-1430 when the sale begins is a long time to stand still.  
                    Even if you are 3129 in line, you will still likely get a bike, but likely not the one you want.
                    
                    We only accept debit or cash.  Visa or MasterCard or American Express are NOT accepted.
                </pre>
            </div>
            <input type="button" value="Sell my bike" class="faqQuestion" onclick='toggleFAQCard("Card5")'>
            <div class="faqAnswerCard" id="Card5">
                <pre>
                    Bring your clean, ready to ride bike to the swap during the bike intake time.

                    You will set the selling price, we can guide you on this.
                    
                    We will tech-check your bike and record its serial number; the bike has to be immediately 
                    rideable. We have participating bike shops in Calgary and Edmonton that can fix your bike 
                    the day of the swap on your dime, our volunteer techs cannot do that for you.
                    
                    You will sign an agreement to sell, which tells us where to send the e-transfer or write you
                    a cheque and what to do with your bike in the slim chance that it doesn’t sell (>92% sell).
                    
                    You will pay us a $15 rack fee per bike to put them into the sale, unless you are an AMA 
                    member. AMA members get $5.00 off, so they pay $10 per bike to get their bike into the swap.
                    
                    You go away (but don’t leave town), we will sell your bike for you and we will send you the 
                    cheque or e-transfer the money, less 13%. You can expect your cheque 1-2 weeks after the swap.
                    It is still a manual process that Laura and Chris complete between swaps, nothing is automagic.
                    
                    In the rare chance your bike doesn’t find a new home, we’ll contact you (cell phone is best) 
                    and let you know to pick your bike up.  It is rather inconvenient if you are out of town and 
                    your bike needs to be picked-up. We only have the space until the end of the swap.
                </pre>
            </div>
        </div>
    </div>
    <footer> Shared Footer component goes here.</footer>
</body>