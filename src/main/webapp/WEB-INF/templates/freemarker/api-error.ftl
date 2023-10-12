<html>
    <head>
        <title>
        </title>
        <style>
		.modal-container {
		margin: 250 auto;
		z-index: 1000;
		background-color: transparent;
		display: flex;
		opacity: 1;
		pointer-events: none;
		transition: opacity 250ms ease;
		}
		
		.modal-section {
		margin: auto;
		width: 90%;
		max-width: 40rem;
		background: linear-gradient(135deg, hsla(212, 98%, 73%, 0.96),hsla(199, 74%, 73%, 0.74));
		border-radius: 1.5rem;
		box-shadow: 0 1rem 2rem #000a;
		}
		
		.modal-header {
		display: flex;
		justify-content: space-between;
		background-color: hsla(212, 73%, 50%, 0.74);
		border-radius: 1.5rem 1.5rem 0 0;
		border: 4px solid hsla(212, 85%, 72%, 0.84);
		border-bottom: none;
		}
		
.modal-title {
  margin: 0;
  color: black;
}

.modal-close {
  color: transparent;
  display: block;
  overflow: hidden;
  background-image:
    linear-gradient(
      to top right,
      transparent 48%,
      black 48%,
      black 52%,
      transparent 52%
    ),
    linear-gradient(
      to top left,
      transparent 48%,
      black 48%,
      black 52%,
      transparent 52%
    );
}

.modal-close:hover,
.modal-close:focus {
  background-image:
    linear-gradient(
      to top right,
      transparent 46%,
      black 46%,
      black 54%,
      transparent 54%
    ),
    linear-gradient(
      to top left,
      transparent 46%,
      black 46%,
      black 54%,
      transparent 54%
    );
}

.modal-content {
  color: black;
  border-radius: 0 0 1.5rem 1.5rem;
  border: 4px solid #f7baf744;
  border-top: none;
}
		
		.modal-header,
		.modal-content {
		padding: 1.5rem;
		}
		
		.modal-container:target {
		opacity: 0;
		pointer-events: all;
		}
		
.button { 
  text-decoration: none;
  display: inline-block;
  padding: 0.5rem 1.25rem;
  color: white;
  background: #4c90b2;
  border: 1px solid #2d566b;
  border-radius: 0.5rem;
  background-image:
    linear-gradient(
      to bottom,
      hsla(200, 40%, 80%, 0.4),
      transparent,
      hsla(200, 40%, 20%, 0.6)
    );
  transition: background-color 0.5s ease;
}

.button::hover,
.button::focus {
  background-color: transparent;
}
        
        body {
  background-color: rgba(0,0,0,0.65);
        }
        </style>
    </head>
    <body>
        <div class="modal-container">
		    <section class="modal-section">
			    <header class="modal-header">
				   <h2 class="modal-title">${error}</h2>
				   <a href="#" class="modal-close">close</a>
			    </header>
				<div class="modal-content">
            <br/>
            <p>${code}</p>
            <p>url: ${url}</p>
            <br />
            <p>${message}</p>
            
            <p><a class="button" href="mailto:${email}">${email}</a></p>
				</div>
			</section>
        </div>
    </body>
</html>